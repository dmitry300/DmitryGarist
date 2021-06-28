package by.training.task03.service;

import by.training.task03.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final SortingLoad sortingBubbleLoad = new BubbleSortLoad();
    private final SortingLoad sortingInsertionLoad = new InsertionSortLoad();
    // private final Sorting sortingInsertionHash = new InsertionHashSort();
    private final SortingLoad sortingShellLoad = new ShellSortLoad();
    private final SortingLoad sortingShakerLoad = new ShakerSortLoad();
    private final SortingLoad sortingSelectionLoad = new SelectionSortLoad();
    private final MergeSortLoad sortingMergeLoad = new MergeSortLoad();
    private final OperationWithMatrixLoad additionLoad = new MatrixAdditionLoad();
    private final OperationWithMatrixLoad subtractionLoad = new MatrixSubtractionLoad();
    private final OperationWithMatrixLoad multiplyLoad = new MatrixMultiplyLoad();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public SortingLoad getSortingBubbleLoad() {
        return sortingBubbleLoad;
    }

    public SortingLoad getSortingInsertionLoad() {
        return sortingInsertionLoad;
    }

    public SortingLoad getSortingShellLoad() {
        return sortingShellLoad;
    }

    public SortingLoad getSortingShakerLoad() {
        return sortingShakerLoad;
    }

    public SortingLoad getSortingSelectionLoad() {
        return sortingSelectionLoad;
    }

    public MergeSortLoad getSortingMergeLoad() {
        return sortingMergeLoad;
    }

    public OperationWithMatrixLoad getAdditionLoad() {
        return additionLoad;
    }

    public OperationWithMatrixLoad getSubtractionLoad() {
        return subtractionLoad;
    }

    public OperationWithMatrixLoad getMultiplyLoad() {
        return multiplyLoad;
    }
}
