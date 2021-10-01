package by.training.xml.controller;

import java.util.EnumMap;

public class CommandProvider {
    private static final CommandProvider instance = new CommandProvider();
    private final EnumMap<CommandType, Command> commands = new EnumMap<>(CommandType.class);

    public static CommandProvider getInstance() {
        return instance;
    }

    private CommandProvider() {
        commands.put(CommandType.SAX, new SaxCommand());
        commands.put(CommandType.STAX, new StaxCommand());
        commands.put(CommandType.DOM, new DomCommand());
        commands.put(CommandType.WRONG_COMMAND, new WrongCommand());
    }

    Command getCommand(String commandName) {
        if (commandName == null) {
            return commands.get(CommandType.WRONG_COMMAND);
        }
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException e) {
            commandType = CommandType.WRONG_COMMAND;
        }
        return commands.get(commandType);
    }
}
