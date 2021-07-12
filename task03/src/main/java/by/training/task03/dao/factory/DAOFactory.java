package by.training.task03.dao.factory;

import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.MatrixDao;
import by.training.task03.dao.impl.FileArrayDao;
import by.training.task03.dao.impl.FileMatrixDao;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ArrayDao fileArrayDao = new FileArrayDao();
    private final MatrixDao fileMatrixDao = new FileMatrixDao();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ArrayDao getFileArrayDao() {
        return fileArrayDao;
    }

    public MatrixDao getFileMatrixDao() {
        return fileMatrixDao;
    }


}
