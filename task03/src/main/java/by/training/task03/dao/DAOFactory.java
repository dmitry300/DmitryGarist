package by.training.task03.dao;

import by.training.task03.dao.impl.FileArrayDao;
import by.training.task03.dao.impl.FileMatrix1Dao;
import by.training.task03.dao.impl.FileMatrix2Dao;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ArrayDao fileArrayDao = new FileArrayDao();
    private final MatrixDao fileMatrix1Dao = new FileMatrix1Dao();
    private final MatrixDao fileMatrix2Dao = new FileMatrix2Dao();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ArrayDao getFileArrayDao() {
        return fileArrayDao;
    }

    public MatrixDao getFileMatrix1Dao() {
        return fileMatrix1Dao;
    }

    public MatrixDao getFileMatrix2Dao() {
        return fileMatrix2Dao;
    }

}
