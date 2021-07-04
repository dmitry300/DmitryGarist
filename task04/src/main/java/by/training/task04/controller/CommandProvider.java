package by.training.task04.controller;

import by.training.task04.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, CommandAccount> repositoryAccount = new HashMap<>();
    private final Map<CommandName, CommandBalance> repositoryBalance = new HashMap<>();
    private final Map<CommandName, CommandBlock> repositoryBlock = new HashMap<>();
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repositoryBlock.put(CommandName.BLOCK_ACCOUNT, new BlockAccount());
        repositoryAccount.put(CommandName.FIND_ACCOUNT, new FindAccount());
        repository.put(CommandName.NEGATIVE_BALANCE_BANK, new NegativeBalanceBank());
        repository.put(CommandName.POSITIVE_BALANCE_BANK, new PositiveBalanceBank());
        repositoryBalance.put(CommandName.POSITIVE_NEGATIVE_SUM_CLIENT, new PosNegSumClient());
        repositoryAccount.put(CommandName.SORT_CLIENT_ACCOUNT, new SortClientAccount());
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

    CommandAccount getCommandAccount(String name) {
        CommandName commandName = null;
        CommandAccount command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repositoryAccount.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
        return command;
    }

    CommandBalance getCommandBalance(String name) {
        CommandName commandName = null;
        CommandBalance command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repositoryBalance.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
        return command;
    }

    CommandBlock getCommandBlock(String name) {
        CommandName commandName = null;
        CommandBlock command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repositoryBlock.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
        return command;
    }
}
