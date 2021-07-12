package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import by.training.task04.service.SeparateSum;

import java.util.LinkedList;
import java.util.List;

public class PosAndNegSumClient implements SeparateSum {
    /**
     * @param bank     entity
     * @param idClient
     * @return int{positive sum accounts,negative sum accounts}
     */
    @Override
    public List<Integer> separateSum(Bank bank, int idClient) {
        List<Integer> posNegSum = new LinkedList<>();
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
        posNegSum.add(positiveSum);
        posNegSum.add(negativeSum);
        return posNegSum;
    }
}
