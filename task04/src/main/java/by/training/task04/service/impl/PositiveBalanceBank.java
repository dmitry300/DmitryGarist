package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import by.training.task04.service.TotalNegAndPosSum;

public class PositiveBalanceBank implements TotalNegAndPosSum {

    @Override
    public int findTotalBalanceClient(Bank bank) {
        int positiveSum = 0;
        for (Client i : bank.getClients()) {
            for (Account account : i.getAccounts()) {
                if (account.getBalance() >= 0) {
                    positiveSum += account.getBalance();
                }
            }
        }
        return positiveSum;
    }
}
