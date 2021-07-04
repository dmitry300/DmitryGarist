package by.training.task04.controller.impl;

import by.training.task04.controller.CommandBalance;
import by.training.task04.service.SeparateSumLoad;
import by.training.task04.service.ServiceFactory;


public class PosNegSumClient implements CommandBalance {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public int[] executeCommand(String idClient) {
        SeparateSumLoad separateSum = serviceFactory.getSeparateSum();
        return separateSum.separateSum(Integer.parseInt(idClient));
    }
}
