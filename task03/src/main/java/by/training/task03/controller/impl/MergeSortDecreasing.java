package by.training.task03.controller.impl;

import by.training.task03.bean.Array;
import by.training.task03.controller.Command;
import by.training.task03.service.LoadingArray;
import by.training.task03.service.factory.ServiceFactory;
import by.training.task03.service.SortingMerge;

public class MergeSortDecreasing implements Command {
    @Override
    public Object executeCommand() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LoadingArray loader = serviceFactory.getLoaderArray();
        Array<Double> array = loader.readArray();
        SortingMerge sorting = serviceFactory.getSortingMerge();
        return sorting.sortDecreasing(array, 0, array.getLength() - 1);
    }
}
