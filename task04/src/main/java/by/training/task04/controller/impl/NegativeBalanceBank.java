package by.training.task04.controller.impl;

import by.training.task04.controller.Command;
import by.training.task04.service.ServiceFactory;
import by.training.task04.service.TotalNegAndPosSumLoad;

public class NegativeBalanceBank implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public int executeCommand(String idClient) {
        TotalNegAndPosSumLoad totalNegAndPosSum = serviceFactory.getTotalNegSum();
        return totalNegAndPosSum.findTotalBalanceClient();
    }
}
