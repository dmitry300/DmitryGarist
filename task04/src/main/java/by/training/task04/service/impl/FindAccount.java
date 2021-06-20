package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.dao.DAOFactory;
import by.training.task04.service.Finding;

public class FindAccount implements Finding {
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public Account[] findAccount(int idClient) {
        for (var client : daoFactory.getBankDao().addAccount().getClients()) {
            if (idClient == client.getIdClient()) {
                return client.getAccounts();
            }
        }
        return new Account[0];
    }
}
