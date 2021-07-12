package by.training.task04.controller.impl;

import by.training.task04.bean.Bank;
import by.training.task04.controller.Command;
import by.training.task04.service.Loading;
import by.training.task04.service.factory.ServiceFactory;
import by.training.task04.service.Sorting;

public class SortClientAccount implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Object executeCommand(String idClient, String fileName) {
        Loading loading = serviceFactory.getLoading();
        Bank bank = loading.readBank(fileName);
        Sorting sorting = serviceFactory.getSorting();
        return sorting.sortAccount(bank);
    }
}
