package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.service.Blocking;

public class BlockAccount implements Blocking {

    @Override
    public boolean block(Bank bank, int idAccount) {
        for (var client : bank.getClients()) {
            for (var account : client.getAccounts()) {
                if (idAccount == account.getIdAccount()) {
                    account.setAccountStatus(false);
                    return account.getAccountStatus();
                }
            }
        }
        return false;
    }

    @Override
    public boolean unblock(Bank bank, int idAccount) {
        for (var client : bank.getClients()) {
            for (var account : client.getAccounts()) {
                if (idAccount == account.getIdAccount()) {
                    account.setAccountStatus(true);
                    return account.getAccountStatus();
                }
            }
        }
        return false;
    }
}
