package by.training.information_handling.dao.provider;

import by.training.information_handling.dao.TextDao;
import by.training.information_handling.dao.impl.TextDaoImpl;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();

    public static DaoProvider getInstance() {
        return instance;
    }

    private DaoProvider() {
    }

    private final TextDao textDao = new TextDaoImpl();

    public TextDao getTextDao() {
        return textDao;
    }
}
