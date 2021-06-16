package by.training.task03.controller.impl;

import by.training.task03.bean.Array;
import by.training.task03.controller.Command;
import by.training.task03.service.ServiceFactory;

import java.util.Arrays;

public class MergeSortDecreasing implements Command {
    @Override
    public String executeCommand() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Array<Number> array = null;
        return Arrays.toString(serviceFactory.getSortingMerge().sortDecreasing(array,0, 28).getArray());
    }
}
