package by.training.task03.controller;

import by.training.task03.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, CommandArray> repositoryArray = new HashMap<>();
    private final Map<CommandName, CommandMatrix> repositoryMatrix = new HashMap<>();

    CommandProvider() {
        repositoryArray.put(CommandName.BUBBLE_SORT_INCREASING, new BubbleSort());
        repositoryArray.put(CommandName.SELECTION_SORT_INCREASING, new SelectionSort());
        repositoryArray.put(CommandName.INSERTION_SORT_INCREASING, new InsertionSort());
        //   repository.put(CommandName.INSERTION_HASH_SORT_INCREASING, new InsertionHashSort());
        repositoryArray.put(CommandName.MERGE_SORT_INCREASING, new MergeSort());
        repositoryArray.put(CommandName.SHAKER_SORT_INCREASING, new ShakerSort());
        repositoryArray.put(CommandName.SHELL_SORT_INCREASING, new ShellSort());
        repositoryArray.put(CommandName.BUBBLE_SORT_DECREASING, new BubbleSortDecreasing());
        repositoryArray.put(CommandName.SELECTION_SORT_DECREASING, new SelectionSortDecreasing());
        repositoryArray.put(CommandName.INSERTION_SORT_DECREASING, new InsertionSortDecreasing());
        //  repository.put(CommandName.INSERTION_HASH_SORT_DECREASING, new InsertionHashSortDecreasing());
        repositoryArray.put(CommandName.MERGE_SORT_DECREASING, new MergeSortDecreasing());
        repositoryArray.put(CommandName.SHAKER_SORT_DECREASING, new ShakerSortDecreasing());
        repositoryArray.put(CommandName.SHELL_SORT_DECREASING, new ShellSortDecreasing());
        repositoryMatrix.put(CommandName.MATRIX_ADDITION, new MatrixAddition());
        repositoryMatrix.put(CommandName.MATRIX_MULTIPLY, new MatrixMultiply());
        repositoryMatrix.put(CommandName.MATRIX_SUBTRACTION, new MatrixSubtraction());
    }

    CommandArray getCommand1(String comName) {
        CommandName commandName;
        try {
            commandName = CommandName.valueOf(comName.toUpperCase());
            return repositoryArray.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    CommandMatrix getCommand2(String comName) {
        CommandName commandName;
        try {
            commandName = CommandName.valueOf(comName.toUpperCase());
            return repositoryMatrix.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
