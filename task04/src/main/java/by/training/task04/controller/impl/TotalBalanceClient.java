package by.training.task04.controller.impl;

import by.training.task04.controller.Command;
import by.training.task04.service.TotalSumClient;
import by.training.task04.service.ServiceFactory;

public class TotalBalanceClient implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public String executeCommand(String idClient) {
        TotalSumClient totalSumClient = serviceFactory.getTotalSumAccount();
        int result = totalSumClient.totalSumAccount(Integer.parseInt(idClient));
        return String.valueOf(result);
    }
}
