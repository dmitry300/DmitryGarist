package by.training.task03.controller.impl;

import by.training.task03.bean.Array;
import by.training.task03.controller.Command;
import by.training.task03.service.ServiceFactory;

import java.util.Arrays;

public class MergeSort implements Command {
    @Override
    public String executeCommand() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Array<Number> array = null;
        return Arrays.toString(serviceFactory.getSortingMerge().sortIncreasing(array,0, 28).getArray());
    }
}
