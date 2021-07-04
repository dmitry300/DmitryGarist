package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import by.training.task04.service.SeparateSum;

public class PosAndNegSumClient implements SeparateSum {
    @Override
    public int[] separateSum(Bank bank, int idClient) {
        int[] posNegSum = new int[2];
        int positiveSum = 0;
        int negativeSum = 0;
        for (Client i : bank.getClients()) {
            if (idClient == i.getIdClient()) {
                for (Account account : i.getAccounts()) {
                    if (account.getBalance() < 0) {
                        negativeSum += account.getBalance();
                    } else {
                        positiveSum += account.getBalance();
                    }
                }
            }
        }
        posNegSum[0] = positiveSum;
        posNegSum[1] = negativeSum;
        return posNegSum;
    }
}
