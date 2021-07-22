package by.training.task05.controller;

import by.training.task05.dao.exception.DaoException;

import java.util.regex.Pattern;

public class Controller {
    private final by.training.task05.controller.CommandProvider provider = new by.training.task05.controller.CommandProvider();
    private static final Pattern DELIMITER = Pattern.compile("\\s*,\\s*");

    public Object execute(String request) throws DaoException {
        String commandName;
        String idObject;
        String fileName;
        String[] params;

        params = request.split(String.valueOf(DELIMITER));
        commandName = params[0];
        idObject = params[1];
        fileName = params[2];
        return provider.getCommand(commandName).executeCommand(idObject, fileName);
    }
}
