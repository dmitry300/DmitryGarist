package by.training.task04.controller.impl;

import by.training.task04.controller.Command;
import by.training.task04.service.ServiceFactory;
import by.training.task04.service.TotalNegAndPosSumLoad;

public class PositiveBalanceBank implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public int executeCommand(String idClient) {
        TotalNegAndPosSumLoad totalNegAndPosSum = serviceFactory.getTotalPosSum();
        return totalNegAndPosSum.findTotalBalanceClient();
    }
}
