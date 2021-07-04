package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import by.training.task04.dao.DAOFactory;
import by.training.task04.service.TotalNegAndPosSumLoad;

public class NegativeBalanceBankLoad implements TotalNegAndPosSumLoad {
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private final Bank bank = daoFactory.getBankDao().addAccountData("C:/Users/KaMo User/IdeaProjects/task04/src/main/java/by/training/task04/data/dataForAccount.txt");

    @Override
    public int findTotalBalanceClient() {
        int negativeSum = 0;
        for (Client i : bank.getClients()) {
            for (Account account : i.getAccounts()) {
                if (account.getBalance() < 0) {
                    negativeSum += account.getBalance();
                }
            }
        }
        return negativeSum;
    }
}

