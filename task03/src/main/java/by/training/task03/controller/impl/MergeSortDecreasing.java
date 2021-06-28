package by.training.task03.controller.impl;

import by.training.task03.bean.Array;
import by.training.task03.controller.CommandArray;
import by.training.task03.service.ServiceFactory;

public class MergeSortDecreasing implements CommandArray {
    @Override
    public Array<Double> executeCommand() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        return serviceFactory.getSortingMergeLoad().sortDecreasing();
    }
}
