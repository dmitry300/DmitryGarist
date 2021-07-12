package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.dao.AccountDao;
import by.training.task04.dao.factory.DAOFactory;
import by.training.task04.service.Loading;

public class Loader implements Loading {
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    public Bank readBank(String fileName) {
        AccountDao accountDao = daoFactory.getBankDao();
        return accountDao.addAccountData(fileName);
    }

}
