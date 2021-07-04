package by.training.task04.controller.impl;

import by.training.task04.controller.Command;
import by.training.task04.service.ServiceFactory;
import by.training.task04.service.TotalSumClientLoad;

public class TotalBalanceClient implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public int executeCommand(String idClient) {
        TotalSumClientLoad totalSumClient = serviceFactory.getTotalSumAccount();
        return totalSumClient.totalSumAccount(Integer.parseInt(idClient));
    }
}
