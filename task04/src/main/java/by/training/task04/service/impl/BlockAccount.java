package by.training.task04.service.impl;

import by.training.task04.dao.DAOFactory;
import by.training.task04.service.Blocking;

public class BlockAccount implements Blocking {
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public boolean block(int idAccount) {
        for (var client : daoFactory.getBankDao().addAccount().getClients()) {
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
    public boolean unblock(int idAccount) {
        for (var client : daoFactory.getBankDao().addAccount().getClients()) {
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
