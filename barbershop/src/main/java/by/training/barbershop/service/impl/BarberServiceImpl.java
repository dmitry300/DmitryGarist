package by.training.barbershop.service.impl;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.dao.BarberDao;
import by.training.barbershop.dao.HaircutDao;
import by.training.barbershop.dao.TransactionDao;
import by.training.barbershop.dao.exception.DaoException;
import by.training.barbershop.dao.impl.AbstractDao;
import by.training.barbershop.dao.impl.DaoFactory;
import by.training.barbershop.service.BarberService;
import by.training.barbershop.service.exception.ServiceException;

import java.util.List;

public class BarberServiceImpl implements BarberService {
    private final DaoFactory daoFactory = DaoFactory.getInstance();
    @Override
    public List<Barber> findBarbers() throws ServiceException {
        BarberDao barberDao = daoFactory.getBarberDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) barberDao);
        try {
            return barberDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
