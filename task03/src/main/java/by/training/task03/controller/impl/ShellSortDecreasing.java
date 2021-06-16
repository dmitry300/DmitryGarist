package by.training.task03.controller.impl;

import by.training.task03.bean.Array;
import by.training.task03.controller.Command;
import by.training.task03.service.ServiceFactory;
import by.training.task03.service.Sorting;

import java.util.Arrays;

public class ShellSortDecreasing implements Command {
    @Override
    public String executeCommand() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Sorting sorting = serviceFactory.getSortingShell();
        Array<Number> array = null;
        return Arrays.toString(sorting.sortDecreasing(array).getArray());
    }
}
