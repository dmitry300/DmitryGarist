package by.training.task03.service.factory;

import by.training.task03.service.*;
import by.training.task03.service.impl.*;
import by.training.task03.service.loader.LoaderArray;
import by.training.task03.service.loader.LoaderMatrix;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final LoadingArray loaderArray = new LoaderArray();
    private final LoadingMatrix loaderMatrix = new LoaderMatrix();
    private final Sorting sortingBubble = new BubbleSort();
    private final Sorting sortingInsertion = new InsertionSort();
    private final Sorting sortingShell = new ShellSort();
    private final Sorting sortingShaker = new ShakerSort();
    private final Sorting sortingSelection = new SelectionSort();
    private final SortingMerge sortingMerge = new MergeSort();
    private final OperationWithMatrix addition = new MatrixAddition();
    private final OperationWithMatrix subtraction = new MatrixSubtraction();
    private final OperationWithMatrix multiply = new MatrixMultiply();

    private ServiceFactory() {
    }

    public LoadingMatrix getLoaderMatrix() {
        return loaderMatrix;
    }

    public LoadingArray getLoaderArray() {
        return loaderArray;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public Sorting getSortingBubble() {
        return sortingBubble;
    }

    public Sorting getSortingInsertion() {
        return sortingInsertion;
    }

    public Sorting getSortingShell() {
        return sortingShell;
    }

    public Sorting getSortingShaker() {
        return sortingShaker;
    }

    public Sorting getSortingSelection() {
        return sortingSelection;
    }

    public SortingMerge getSortingMerge() {
        return sortingMerge;
    }

    public OperationWithMatrix getAddition() {
        return addition;
    }

    public OperationWithMatrix getSubtraction() {
        return subtraction;
    }

    public OperationWithMatrix getMultiply() {
        return multiply;
    }
}
