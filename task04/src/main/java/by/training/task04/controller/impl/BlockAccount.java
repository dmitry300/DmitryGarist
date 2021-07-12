package by.training.task04.controller.impl;

import by.training.task04.bean.Bank;
import by.training.task04.controller.Command;
import by.training.task04.service.Blocking;
import by.training.task04.service.Loading;
import by.training.task04.service.factory.ServiceFactory;

public class BlockAccount implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Object executeCommand(String idClient, String fileName) {
        Loading loading = serviceFactory.getLoading();
        Bank bank = loading.readBank(fileName);
        Blocking blocking = serviceFactory.getBlocking();
        return blocking.block(bank, Integer.parseInt(idClient));
    }
}
