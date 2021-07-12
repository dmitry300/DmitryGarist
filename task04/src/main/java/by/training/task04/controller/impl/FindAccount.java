package by.training.task04.controller.impl;

import by.training.task04.bean.Bank;
import by.training.task04.controller.Command;
import by.training.task04.service.Finding;
import by.training.task04.service.Loading;
import by.training.task04.service.factory.ServiceFactory;

public class FindAccount implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Object executeCommand(String idClient, String fileName) {
        Loading loading = serviceFactory.getLoading();
        Bank bank = loading.readBank(fileName);
        Finding finding = serviceFactory.getFinding();
        return finding.findAccount(bank, Integer.parseInt(idClient));
    }
}
