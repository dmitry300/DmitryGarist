package by.training.barbershop.service.impl;

import by.training.barbershop.bean.Haircut;
import by.training.barbershop.dao.HaircutDao;
import by.training.barbershop.dao.TransactionDao;
import by.training.barbershop.dao.exception.DaoException;
import by.training.barbershop.dao.impl.AbstractDao;
import by.training.barbershop.dao.impl.DaoFactory;
import by.training.barbershop.service.HaircutService;
import by.training.barbershop.service.exception.ServiceException;

import java.util.List;

public class HaircutServiceImpl implements HaircutService {
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<Haircut> findHaircuts() throws ServiceException {
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) haircutDao);
        try {
            return haircutDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }finally {
            transactionDao.endTransaction();
        }
    }
}
