package by.training.task03.controller.impl;

import by.training.task03.bean.Array;
import by.training.task03.controller.Command;
import by.training.task03.service.LoadingArray;
import by.training.task03.service.factory.ServiceFactory;
import by.training.task03.service.Sorting;

public class ShellSortDecreasing implements Command {
    @Override
    public Object executeCommand() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LoadingArray loader = serviceFactory.getLoaderArray();
        Array<Double> array = loader.readArray();
        Sorting sorting = serviceFactory.getSortingShell();
        return sorting.sortDecreasing(array);
    }
}
