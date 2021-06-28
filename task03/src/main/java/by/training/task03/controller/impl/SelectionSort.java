package by.training.task03.controller.impl;

import by.training.task03.bean.Array;
import by.training.task03.controller.CommandArray;
import by.training.task03.service.ServiceFactory;
import by.training.task03.service.SortingLoad;

public class SelectionSort implements CommandArray {
    @Override
    public Array<Double> executeCommand() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortingLoad sortingLoad = serviceFactory.getSortingSelectionLoad();
        return sortingLoad.sortIncreasing();
    }
}
