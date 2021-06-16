package by.training.task03.service;

import by.training.task03.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final Sorting sortingBubble = new BubbleSort();
    private final Sorting sortingInsertion = new InsertionSort();
   // private final Sorting sortingInsertionHash = new InsertionHashSort();
    private final Sorting sortingShell = new ShellSort();
    private final Sorting sortingShaker = new ShakerSort();
    private final Sorting sortingSelection = new SelectionSort();
    private final MergeSort sortingMerge = new MergeSort();
    private final OperationWithMatrix addition = new MatrixAddition();
    private final OperationWithMatrix substraction = new MatrixSubtraction();
    private final OperationWithMatrix multiply = new MatrixMultiply();

    private ServiceFactory() {
    }

    public Sorting getSortingInsertion() {
        return sortingInsertion;
    }

//    public Sorting getSortingInsertionHash() {
//        return sortingInsertionHash;
//    }

    public Sorting getSortingShell() {
        return sortingShell;
    }

    public Sorting getSortingShaker() {
        return sortingShaker;
    }

    public Sorting getSortingSelection() {
        return sortingSelection;
    }

    public MergeSort getSortingMerge() {
        return sortingMerge;
    }

    public OperationWithMatrix getAddition() {
        return addition;
    }

    public OperationWithMatrix getSubtraction() {
        return substraction;
    }

    public OperationWithMatrix getMultiply() {
        return multiply;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public Sorting getSortingBubble() {
        return sortingBubble;
    }

}
