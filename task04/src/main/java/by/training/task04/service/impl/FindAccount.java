package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.service.Finding;

import java.util.ArrayList;
import java.util.List;

public class FindAccount implements Finding {

    @Override
    public List<Account> findAccount(Bank bank, int idClient) {
        for (var client : bank.getClients()) {
            if (idClient == client.getIdClient()) {
                return client.getAccounts();
            }
        }
        return new ArrayList<>();
    }
}
