package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.dao.DAOFactory;
import by.training.task04.service.TotalNegAndPosSumLoad;

public class PositiveBalanceBankLoad implements TotalNegAndPosSumLoad {
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private final Bank bank = daoFactory.getBankDao().addAccountData("C:/Users/KaMo User/IdeaProjects/task04/src/main/java/by/training/task04/data/dataForAccount.txt");

    @Override
    public int findTotalBalanceClient() {

        return new PositiveBalanceBank().findTotalBalanceClient(bank);
    }
}
