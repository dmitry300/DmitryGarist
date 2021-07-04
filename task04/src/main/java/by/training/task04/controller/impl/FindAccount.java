package by.training.task04.controller.impl;

import by.training.task04.bean.Account;
import by.training.task04.controller.CommandAccount;
import by.training.task04.service.FindingLoad;
import by.training.task04.service.ServiceFactory;

import java.util.List;

public class FindAccount implements CommandAccount {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public List<Account> executeCommand(String idClient) {
        FindingLoad finding = serviceFactory.getFinding();
        return finding.findAccount(Integer.parseInt(idClient));
    }
}
