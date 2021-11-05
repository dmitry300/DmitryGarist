package by.training.barbershop.service.impl;

import by.training.barbershop.bean.Haircut;
import by.training.barbershop.dao.HaircutDao;
import by.training.barbershop.dao.Transaction;
import by.training.barbershop.dao.exception.DaoException;
import by.training.barbershop.dao.exception.DatabaseConnectionException;
import by.training.barbershop.dao.impl.AbstractDao;
import by.training.barbershop.dao.impl.DaoFactory;
import by.training.barbershop.service.HaircutService;
import by.training.barbershop.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class HaircutServiceImpl implements HaircutService {
    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private final Transaction transaction = daoFactory.getTransactionDao();

    @Override
    public List<Haircut> findHaircuts() throws ServiceException {
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        try {
            transaction.initTransaction((AbstractDao) haircutDao);
            return haircutDao.findAll();
        } catch (DaoException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public Haircut findHaircutById(int id) throws ServiceException {
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        try {
            transaction.initTransaction((AbstractDao) haircutDao);
            return haircutDao.findEntityById(id);
        } catch (DaoException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean addHaircut(Haircut haircut) throws ServiceException, SQLException {
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        try {
            transaction.initTransaction((AbstractDao) haircutDao);
            return haircutDao.create(haircut) != 0;
        } catch (DaoException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean removeHaircut(int id) throws ServiceException, SQLException {
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        try {
            transaction.initTransaction((AbstractDao) haircutDao);
            return haircutDao.delete(id);
        } catch (DaoException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public Haircut updateHaircut(Haircut haircut) throws ServiceException {
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        try {
            transaction.initTransaction((AbstractDao) haircutDao);
            return haircutDao.update(haircut);
        } catch (DaoException | DatabaseConnectionException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }
}
