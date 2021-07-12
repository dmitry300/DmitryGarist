package by.training.task04.controller;

import by.training.task04.controller.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;

public class CommandProvider {
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);

    CommandProvider() {
        repository.put(CommandName.BLOCK_ACCOUNT, new BlockAccount());
        repository.put(CommandName.FIND_ACCOUNT, new FindAccount());
        repository.put(CommandName.NEGATIVE_BALANCE_BANK, new NegativeBalanceBank());
        repository.put(CommandName.POSITIVE_BALANCE_BANK, new PositiveBalanceBank());
        repository.put(CommandName.POSITIVE_NEGATIVE_SUM_CLIENT, new PosNegSumClient());
        repository.put(CommandName.SORT_CLIENT_ACCOUNT, new SortClientAccount());
        repository.put(CommandName.TOTAL_BALANCE_CLIENT, new TotalBalanceClient());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException e) {
            logger.error("That command doesn't exist!");
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
