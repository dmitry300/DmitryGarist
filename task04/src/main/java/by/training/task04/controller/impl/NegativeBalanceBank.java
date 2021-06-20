package by.training.task04.controller.impl;

import by.training.task04.controller.Command;
import by.training.task04.service.TotalNegAndPosSum;
import by.training.task04.service.ServiceFactory;

public class NegativeBalanceBank implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public String executeCommand(String idClient) {
        TotalNegAndPosSum totalNegAndPosSum = serviceFactory.getTotalNegSum();
        int result = totalNegAndPosSum.findTotalBalanceClient();
        return String.valueOf(result);
    }
}
