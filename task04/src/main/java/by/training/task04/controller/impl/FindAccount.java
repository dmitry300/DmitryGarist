package by.training.task04.controller.impl;

import by.training.task04.bean.Account;
import by.training.task04.controller.Command;
import by.training.task04.service.Finding;
import by.training.task04.service.ServiceFactory;

public class FindAccount implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public String executeCommand(String idClient) {
        Finding finding = serviceFactory.getFinding();
        Account[] accounts = finding.findAccount(Integer.parseInt(idClient));
        return accounts.toString();
    }
}
