package by.training.task03.controller;

import by.training.task03.bean.MatrixException;

import java.io.IOException;

public class Controller  {
    private final CommandProvider provider = new CommandProvider();
    //private final char paramDelimeter = ' ';

    public String execute(String request) throws MatrixException, IOException {
        String commandName;
        String[] params;

        params = request.split("\\s+");
        commandName = params[0];
        Command currentCommand = provider.getCommand(commandName);
        String response;
        response = currentCommand.executeCommand();

        return response;
    }
}
