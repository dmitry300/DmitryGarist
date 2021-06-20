package by.training.task04.controller;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public String execute(String request) {
        String commandName;
        String idClient;
        String[] params;

        params = request.split("\\s+");
        commandName = params[0];
        idClient = params[1];
        Command currentCommand = provider.getCommand(commandName);
        String response;
        response = currentCommand.executeCommand(idClient);

        return response;
    }
}
