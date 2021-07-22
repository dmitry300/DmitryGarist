package by.training.task05.controller;

import by.training.task05.controller.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;

public class CommandProvider {
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);

    CommandProvider() {
        repository.put(CommandName.SQUARE_BALL, new SquareBall());
        repository.put(CommandName.VOLUME_BALL, new VolumeBall());
        repository.put(CommandName.TOUCHING_BALL, new TouchingBall());
        repository.put(CommandName.DISSECTION_BALL, new DissectionBall());
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
