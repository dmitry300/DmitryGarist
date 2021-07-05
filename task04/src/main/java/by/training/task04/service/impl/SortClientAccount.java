package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import by.training.task04.service.Sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortClientAccount implements Sorting {
    /**
     * @param bank entity
     * @return sorted array of accounts of all clients by balance ascending
     */
    @Override
    public List<Account> sortAccount(Bank bank) {
        List<Account> sortAccounts = new LinkedList<>();
        for (Client i : bank.getClients()) {
            sortAccounts.addAll(i.getAccounts());
        }
        sortAccounts.sort(new Comparator<>() {//сортировка всех счетов по балансу по возрастанию.

            @Override
            public int compare(Account o1, Account o2) {
                return o1.getBalance() - o2.getBalance();
            }
        });
        return sortAccounts;
    }
}
