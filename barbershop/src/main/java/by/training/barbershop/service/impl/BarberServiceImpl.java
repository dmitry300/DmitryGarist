package by.training.barbershop.service.impl;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.dao.BarberDao;
import by.training.barbershop.dao.Transaction;
import by.training.barbershop.dao.exception.DaoException;
import by.training.barbershop.dao.exception.DatabaseConnectionException;
import by.training.barbershop.dao.impl.AbstractDao;
import by.training.barbershop.dao.impl.DaoFactory;
import by.training.barbershop.service.BarberService;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Properties;

public class BarberServiceImpl implements BarberService {
    private static final Logger log = LogManager.getLogger(BarberServiceImpl.class);
    private static final DaoFactory daoFactory = DaoFactory.getInstance();
    Transaction transaction = daoFactory.getTransactionDao();
    private String basePicturePath;
    private String barberFolderPath;

    public BarberServiceImpl() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Properties properties = new Properties();
            properties.load(classLoader.getResourceAsStream("properties/img.properties"));
            basePicturePath = properties.getProperty("image.path.base");
            barberFolderPath = properties.getProperty("image.path.barber");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public List<Barber> findActiveBarbers() throws ServiceException {
        BarberDao barberDao = daoFactory.getBarberDao();
        try {
            transaction.initTransaction((AbstractDao) barberDao);
            List<Barber> barbers = barberDao.findAll();
            barbers = barbers.stream()
                    .filter(barber -> barber.getEndJob() == null
                            || barber.getEndJob()
                            .after(Date.valueOf(LocalDate.now())))
                    .toList();
            for (var barber : barbers) {
                int age = Period.between(barber.getBirthday().toLocalDate(), LocalDate.now()).getYears();
                barber.setAge(age);
            }
            transaction.commit();
            return barbers;
        } catch (DaoException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public List<Barber> findDismissedBarbers() throws ServiceException {
        BarberDao barberDao = daoFactory.getBarberDao();
        try {
            transaction.initTransaction((AbstractDao) barberDao);
            List<Barber> barbers = barberDao.findAll();
            barbers.removeIf(barber -> barber.getEndJob() == null);
            barbers.removeIf(barber -> barber.getEndJob().after(Date.valueOf(LocalDate.now())));
            for (var barber : barbers) {
                int age = Period.between(barber.getBirthday().toLocalDate(), LocalDate.now()).getYears();
                barber.setAge(age);
            }
            transaction.commit();
            return barbers;
        } catch (DaoException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public Barber findBarberById(int id) throws ServiceException {
        BarberDao barberDao = daoFactory.getBarberDao();
        try {
            transaction.initTransaction((AbstractDao) barberDao);
            Barber barber = barberDao.findEntityById(id);
            int age = Period.between(barber.getBirthday().toLocalDate(), LocalDate.now()).getYears();
            barber.setAge(age);
            return barber;
        } catch (DaoException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean addNewBarber(Barber barber, List<Part> imageParts) throws ServiceException {
        BarberDao barberDao = daoFactory.getBarberDao();
        String relativeImagePath = barberFolderPath + barber.getSurname() + ".jpeg";
        barber.setPhoto(relativeImagePath);
        savePicture(relativeImagePath, imageParts);
        try {
            transaction.initTransaction((AbstractDao) barberDao);
            barberDao.create(barber);
            transaction.commit();
            return true;
        } catch (DaoException | SQLException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean removeBarber(int id) throws ServiceException {
        BarberDao barberDao = daoFactory.getBarberDao();
        try {
            transaction.initTransaction((AbstractDao) barberDao);
            barberDao.delete(id);
            transaction.commit();
            return true;
        } catch (DaoException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean updateBarberWithImg(Barber barber, List<Part> imageParts) throws ServiceException {
        BarberDao barberDao = daoFactory.getBarberDao();
        String relativeImagePath = barberFolderPath + barber.getSurname() + ".jpeg";
        barber.setPhoto(relativeImagePath);
        savePicture(relativeImagePath, imageParts);
        try {
            transaction.initTransaction((AbstractDao) barberDao);
            barberDao.update(barber);
            transaction.commit();
            return true;
        } catch (DaoException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean updateBarber(Barber barber) throws ServiceException {
        BarberDao barberDao = daoFactory.getBarberDao();
        try {
            transaction.initTransaction((AbstractDao) barberDao);
            barberDao.update(barber);
            transaction.commit();
            return true;
        } catch (DaoException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    private void savePicture(String relativePath, List<Part> imageParts) throws ServiceException {
        String absolutePath = basePicturePath + relativePath;
        try (FileOutputStream fileOutputStream = new FileOutputStream(absolutePath)) {
            for (Part part : imageParts) {
                part.getInputStream().transferTo(fileOutputStream);
            }
        } catch (IOException e) {
            throw new ServiceException("Error while saving image. " + e.getMessage(), e);
        }
    }
}
