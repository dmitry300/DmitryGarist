package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.service.Blocking;

public class BlockAccount implements Blocking {

    /**
     * @param bank      entity that saves clients[]
     * @param idAccount
     * @return boolean false
     */
    @Override
    public Boolean block(Bank bank, int idAccount) {
        boolean accountStatus = false;
        for (var client : bank.getClients()) {
            for (var account : client.getAccounts()) {
                if (idAccount == account.getIdAccount()) {
                    account.setAccountStatus(false);
                    accountStatus = account.getAccountStatus();
                }
            }
        }
        return accountStatus;
    }

    /**
     * @param bank      entity that saves clients[]
     * @param idAccount
     * @return boolean true
     */
    @Override
    public Boolean unblock(Bank bank, int idAccount) {
        boolean accountStatus = false;
        for (var client : bank.getClients()) {
            for (var account : client.getAccounts()) {
                if (idAccount == account.getIdAccount()) {
                    account.setAccountStatus(true);
                    accountStatus = account.getAccountStatus();
                }
            }
        }
        return accountStatus;
    }
}
