package by.training.barbershop.controller;

import by.training.barbershop.controller.impl.*;

import java.util.EnumMap;

public class CommandProvider {
    private static final CommandProvider instance = new CommandProvider();
    private final EnumMap<CommandType, Command> commands = new EnumMap<>(CommandType.class);

    public static CommandProvider getInstance() {
        return instance;
    }

    private CommandProvider() {
        commands.put(CommandType.REGISTRATION, new RegistrationCommand());
        commands.put(CommandType.HOME, new HomeCommand());
        commands.put(CommandType.LOGIN, new LoginCommand());
        commands.put(CommandType.GO_TO_REGISTRATION, new GoToRegistrationCommand());
        commands.put(CommandType.GO_TO_LOGIN, new GoToLoginCommand());
        commands.put(CommandType.GO_TO_ABOUT_US, new GoToAboutUsCommand());
        commands.put(CommandType.LANGUAGE, new LanguageCommand());
        commands.put(CommandType.SERVICES, new ServiceListCommand());
        commands.put(CommandType.BARBERS, new BarberListCommand());
        commands.put(CommandType.ERROR, new Error404Command());
    }

    public Command getCommand(String commandName) {
        if (commandName == null) {
            return commands.get(CommandType.ERROR);
        }
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException e) {
            commandType = CommandType.ERROR;
        }
        return commands.get(commandType);
    }
}
