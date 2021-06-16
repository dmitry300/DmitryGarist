package by.training.task03.controller.impl;

import by.training.task03.bean.Array;
import by.training.task03.controller.Command;
import by.training.task03.service.ServiceFactory;
import by.training.task03.service.Sorting;

import java.util.Arrays;

public class InsertionSortDecreasing implements Command {
    @Override
    public String executeCommand() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Sorting sorting = serviceFactory.getSortingInsertion();
        Array array = null;
        return Arrays.toString(sorting.sortDecreasing(array).getArray()); 
    }
}
