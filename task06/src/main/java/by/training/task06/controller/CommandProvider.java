package by.training.task06.controller;

import by.training.task06.controller.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;

public class CommandProvider {
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);

    CommandProvider() {
        repository.put(CommandName.LOCKER, new LockerThread());
        repository.put(CommandName.SEMAPHORE, new SemaphoreThread());
        repository.put(CommandName.PHASER, new PhaserThread());
        repository.put(CommandName.CYCLIC_BARRIER, new CyclicBarrierThread());
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
