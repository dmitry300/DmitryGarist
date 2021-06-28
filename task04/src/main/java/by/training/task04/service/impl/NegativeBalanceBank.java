package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import by.training.task04.dao.DAOFactory;
import by.training.task04.service.TotalNegAndPosSum;

public class NegativeBalanceBank implements TotalNegAndPosSum {
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public int findTotalBalanceClient() {
        Bank bank = daoFactory.getBankDao().addAccount();
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
