package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.service.Finding;
import java.util.LinkedList;
import java.util.List;

public class FindAccount implements Finding {

    /**
     * @param bank     entity
     * @param idClient
     * @return accounts[] for certain client
     */
    @Override
    public List<Account> findAccount(Bank bank, int idClient) {
        List<Account> accounts = new LinkedList<>();
        for (var client : bank.getClients()) {
            if (idClient == client.getIdClient()) {
                accounts = client.getAccounts(); //TODO отдать копию
            }
        }
        return accounts;
    }
}
