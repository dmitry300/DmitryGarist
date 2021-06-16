package by.training.task03.controller.impl;

import by.training.task03.bean.Array;
import by.training.task03.controller.Command;
import by.training.task03.service.Sorting;
import by.training.task03.service.ServiceFactory;

import java.util.Arrays;

public class SelectionSort implements Command {
    @Override
    public String executeCommand() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Sorting sorting = serviceFactory.getSortingSelection();
        Array<Number> array = null;
        return Arrays.toString(sorting.sortIncreasing(array).getArray());
    }
}
