package by.training.task04.controller.impl;

import by.training.task04.bean.Account;
import by.training.task04.controller.CommandAccount;
import by.training.task04.service.ServiceFactory;
import by.training.task04.service.SortingLoad;

import java.util.List;

public class SortClientAccount implements CommandAccount {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public List<Account> executeCommand(String idClient) {
        SortingLoad sorting = serviceFactory.getSorting();
        return sorting.sortAccount();
    }
}
