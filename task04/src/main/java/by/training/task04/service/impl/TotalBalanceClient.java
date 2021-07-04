package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import by.training.task04.service.TotalSumClient;

public class TotalBalanceClient implements TotalSumClient {

    @Override
    public int totalSumAccount(Bank bank,int idClient) {
        int totalSum = 0;
        for (Client i : bank.getClients()) {
            if (idClient == i.getIdClient()) {
                for (Account account : i.getAccounts()) {
                    totalSum += account.getBalance();
                }
            }
        }
        return totalSum;
    }
}
