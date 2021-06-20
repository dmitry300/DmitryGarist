package by.training.task04.controller.impl;

import by.training.task04.controller.Command;
import by.training.task04.service.Blocking;
import by.training.task04.service.ServiceFactory;

public class BlockAccount implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public String executeCommand(String idClient) {
        Blocking blocking = serviceFactory.getBlocking();
        boolean result = blocking.block(Integer.parseInt(idClient));
        return "Blocking is done, status of the account = " + result;
    }
}
