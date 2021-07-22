package by.training.task05.service.impl;

import by.training.task05.bean.Ball;
import by.training.task05.dao.exception.DaoException;
import by.training.task05.dao.provider.DaoProvider;
import by.training.task05.service.Loading;
import by.training.task05.service.exception.ServiceException;

import java.util.List;

public class Loader implements Loading {
    private final DaoProvider daoProvider = DaoProvider.getInstance();

    @Override
    public List<Ball> read(String fileName) throws ServiceException {
        try {
            return daoProvider.getBallDao().saveBall(fileName);
        }catch (DaoException e){
            throw new ServiceException(e);
        }

    }
}
