package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import by.training.task04.dao.DAOFactory;
import by.training.task04.service.Sorting;

public class SortClientAccount implements Sorting {
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public Account[] sortAccount(int idClient) {
        Bank bank = daoFactory.getBankDao().addAccount();
        Account[] sortAccounts = null;
        for (Client i : bank.getClients()) {
            if (idClient == i.getIdClient()) {
                sortAccounts = i.getAccounts();
            }
        }
        if (sortAccounts != null) {
            for (int i = 0; i < sortAccounts.length - 1; i++) {
                for (int j = 0; j < i; j++) {
                    if (sortAccounts[j].getBalance  () < sortAccounts[j + 1].getBalance()) {
                        Account tmp = sortAccounts[j];
                        sortAccounts[j] = sortAccounts[j + 1];
                        sortAccounts[j + 1] = tmp;
                    }
                }
            }
        }
        return sortAccounts;
    }
}
