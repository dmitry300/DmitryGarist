package by.training.task04.controller.impl;

import by.training.task04.controller.Command;
import by.training.task04.service.SeparateSum;
import by.training.task04.service.ServiceFactory;

import java.util.Arrays;

public class PosNegSumClient implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public String executeCommand(String idClient) {
        SeparateSum separateSum = serviceFactory.getSeparateSum();
        int[] result = separateSum.separateSum(Integer.parseInt(idClient));
        return Arrays.toString(result);
    }
}
