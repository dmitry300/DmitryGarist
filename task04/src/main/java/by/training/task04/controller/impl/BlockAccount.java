package by.training.task04.controller.impl;

import by.training.task04.controller.CommandBlock;
import by.training.task04.service.BlockingLoad;
import by.training.task04.service.ServiceFactory;

public class BlockAccount implements CommandBlock {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public boolean executeCommand(String idClient) {
        BlockingLoad blocking = serviceFactory.getBlocking();
        return blocking.block(Integer.parseInt(idClient));
    }
}
