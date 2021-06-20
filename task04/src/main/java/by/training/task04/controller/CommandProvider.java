package by.training.task04.controller;

import by.training.task04.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.BLOCK_ACCOUNT, new BlockAccount());
        repository.put(CommandName.FIND_ACCOUNT, new FindAccount());
        repository.put(CommandName.NEGATIVE_BALANCE_BANK, new NegativeBalanceBank());
        repository.put(CommandName.POSITIVE_BALANCE_BANK, new PositiveBalanceBank());
        repository.put(CommandName.POSITIVE_NEGATIVE_SUM_CLIENT, new PosNegSumClient());
        repository.put(CommandName.SORT_CLIENT_ACCOUNT, new SortClientAccount());
        repository.put(CommandName.TOTAL_BALANCE_CLIENT, new TotalBalanceClient());
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
