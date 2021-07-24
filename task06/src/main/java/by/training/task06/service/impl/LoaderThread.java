package by.training.task06.service.impl;

import by.training.task06.dao.exception.DaoException;
import by.training.task06.dao.provider.DaoProvider;
import by.training.task06.service.Loading;
import by.training.task06.service.exception.ServiceException;

public class LoaderThread implements Loading {
    private final DaoProvider daoProvider = DaoProvider.getInstance();

    @Override
    public Object read(String fileName) throws ServiceException {
        try {
            return daoProvider.getFileThreadDao().saveThreadNumber(fileName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
