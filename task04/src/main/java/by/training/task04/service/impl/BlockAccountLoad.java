package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.dao.DAOFactory;
import by.training.task04.service.BlockingLoad;

public class BlockAccountLoad implements BlockingLoad {
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private final Bank bank = daoFactory.getBankDao().addAccountData("C:/Users/KaMo User/IdeaProjects/task04/src/main/java/by/training/task04/data/dataForAccount.txt");

    @Override
    public boolean block(int idAccount) {

        return new BlockAccount().block(bank, idAccount);
    }

    @Override
    public boolean unblock(int idAccount) {

        return new BlockAccount().unblock(bank, idAccount);
    }
}
