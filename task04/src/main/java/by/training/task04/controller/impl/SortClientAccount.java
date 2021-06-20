package by.training.task04.controller.impl;

import by.training.task04.bean.Account;
import by.training.task04.controller.Command;
import by.training.task04.service.Sorting;
import by.training.task04.service.ServiceFactory;

public class SortClientAccount implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public String executeCommand(String idClient) {
        Sorting sorting = serviceFactory.getSorting();
        Account[] accounts = sorting.sortAccount(Integer.parseInt(idClient));
        return accounts.toString();
    }
}
