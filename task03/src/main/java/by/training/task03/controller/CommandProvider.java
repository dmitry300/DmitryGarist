package by.training.task03.controller;

import by.training.task03.controller.impl.*;

import java.util.EnumMap;

public class CommandProvider {
    private final EnumMap<CommandName, Object> repository = new EnumMap<>(CommandName.class);

    CommandProvider() {
        repository.put(CommandName.BUBBLE_SORT_INCREASING, new BubbleSort());
        repository.put(CommandName.SELECTION_SORT_INCREASING, new SelectionSort());
        repository.put(CommandName.INSERTION_SORT_INCREASING, new InsertionSort());
        repository.put(CommandName.MERGE_SORT_INCREASING, new MergeSort());
        repository.put(CommandName.SHAKER_SORT_INCREASING, new ShakerSort());
        repository.put(CommandName.SHELL_SORT_INCREASING, new ShellSort());
        repository.put(CommandName.BUBBLE_SORT_DECREASING, new BubbleSortDecreasing());
        repository.put(CommandName.SELECTION_SORT_DECREASING, new SelectionSortDecreasing());
        repository.put(CommandName.INSERTION_SORT_DECREASING, new InsertionSortDecreasing());
        repository.put(CommandName.MERGE_SORT_DECREASING, new MergeSortDecreasing());
        repository.put(CommandName.SHAKER_SORT_DECREASING, new ShakerSortDecreasing());
        repository.put(CommandName.SHELL_SORT_DECREASING, new ShellSortDecreasing());
        repository.put(CommandName.MATRIX_ADDITION, new MatrixAddition());
        repository.put(CommandName.MATRIX_MULTIPLY, new MatrixMultiply());
        repository.put(CommandName.MATRIX_SUBTRACTION, new MatrixSubtraction());
    }

    Command getCommand(String comName) {
        CommandName commandName;
        try {
            commandName = CommandName.valueOf(comName.toUpperCase());
            return (Command) repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

}
