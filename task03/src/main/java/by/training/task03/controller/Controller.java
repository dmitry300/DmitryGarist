package by.training.task03.controller;

import by.training.task03.bean.MatrixException;

import java.io.IOException;
import java.util.regex.Pattern;

public class Controller {
    private final CommandProvider provider = new CommandProvider();
    private static final Pattern DELIMITER = Pattern.compile("\\s* \\s*");

    public Object execute(String request) throws MatrixException, IOException {
        String commandName;
        String[] params;

        params = request.split(String.valueOf(DELIMITER));
        commandName = params[0];
        return provider.getCommand(commandName).executeCommand();
    }
}
