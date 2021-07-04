package by.training.task04.dao;

import by.training.task04.dao.impl.AccountDaoImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final AccountDao bankDao = new AccountDaoImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public AccountDao getBankDao() {
        return bankDao;
    }
}
