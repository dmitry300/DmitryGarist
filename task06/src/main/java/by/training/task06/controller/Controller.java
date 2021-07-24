package by.training.task06.controller;

import java.util.regex.Pattern;

public class Controller {
    private final CommandProvider provider = new CommandProvider();
    private static final Pattern DELIMITER = Pattern.compile("\\s*,\\s*");

    public void execute(String request){
        String commandName;
        String fileNameForMatrix;
        String fileNameForThread;
        String[] params;

        params = request.split(String.valueOf(DELIMITER));
        commandName = params[0];
        fileNameForMatrix = params[1];
        fileNameForThread = params[2];
        provider.getCommand(commandName).executeCommand(fileNameForMatrix, fileNameForThread);
    }
}
