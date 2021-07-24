package by.training.task06.dao.provider;

import by.training.task06.dao.ThreadDao;
import by.training.task06.dao.impl.FileMatrixDao;
import by.training.task06.dao.MatrixDao;
import by.training.task06.dao.impl.FileThreadDao;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();

    public static DaoProvider getInstance() {
        return instance;
    }

    private DaoProvider() {
    }

    private final MatrixDao fileMatrixDao = new FileMatrixDao();
    private final ThreadDao fileThreadDao = new FileThreadDao();

    public ThreadDao getFileThreadDao() {
        return fileThreadDao;
    }

    public MatrixDao getFileMatrixDao() {
        return fileMatrixDao;
    }
}
