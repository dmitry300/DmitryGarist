package by.training.task06.service.impl;

import by.training.task06.bean.MatrixException;
import by.training.task06.dao.exception.DaoException;
import by.training.task06.dao.provider.DaoProvider;
import by.training.task06.service.Loading;
import by.training.task06.service.exception.ServiceException;

import java.io.IOException;

public class LoaderMatrix implements Loading {
    private final DaoProvider daoProvider = DaoProvider.getInstance();

    @Override
    public Object read(String fileName) throws ServiceException {
        try {
            return daoProvider.getFileMatrixDao().saveMatrix(fileName);
        } catch (DaoException | MatrixException | IOException e) {
            throw new ServiceException(e);
        }
    }
}
