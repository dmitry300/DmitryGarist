package by.training.task04.controller;

import java.util.regex.Pattern;

public class Controller {
    private final CommandProvider provider = new CommandProvider();
    private static final Pattern DELIMITER = Pattern.compile("\\s*,\\s*");

    public Object execute(String request) {
        String commandName;
        String idClient;
        String fileName;
        String[] params;

        params = request.split(String.valueOf(DELIMITER));
        commandName = params[0];
        idClient = params[1];
        fileName = params[2];
        return provider.getCommand(commandName).executeCommand(idClient, fileName);
    }
}
