package by.training.task03.controller;


import by.training.task03.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.BUBBLE_SORT_INCREASING, new BubbleSort());
        repository.put(CommandName.SELECTION_SORT_INCREASING, new SelectionSort());
        repository.put(CommandName.INSERTION_SORT_INCREASING, new InsertionSort());
     //   repository.put(CommandName.INSERTION_HASH_SORT_INCREASING, new InsertionHashSort());
        repository.put(CommandName.MERGE_SORT_INCREASING, new MergeSort());
        repository.put(CommandName.SHAKER_SORT_INCREASING, new ShakerSort());
        repository.put(CommandName.SHELL_SORT_INCREASING, new ShellSort());
      repository.put(CommandName.BUBBLE_SORT_DECREASING, new BubbleSortDecreasing());
        repository.put(CommandName.SELECTION_SORT_DECREASING, new SelectionSortDecreasing());
        repository.put(CommandName.INSERTION_SORT_DECREASING, new InsertionSortDecreasing());
      //  repository.put(CommandName.INSERTION_HASH_SORT_DECREASING, new InsertionHashSortDecreasing());
        repository.put(CommandName.MERGE_SORT_DECREASING, new MergeSortDecreasing());
        repository.put(CommandName.SHAKER_SORT_DECREASING, new ShakerSortDecreasing());
        repository.put(CommandName.SHELL_SORT_DECREASING, new ShellSortDecreasing());
        repository.put(CommandName.MATRIX_ADDITION, new MatrixAddition());
        repository.put(CommandName.MATRIX_MULTIPLY, new MatrixMultiply());
        repository.put(CommandName.MATRIX_SUBTRACTION, new MatrixSubtraction());


    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
        return command;
    }
}
