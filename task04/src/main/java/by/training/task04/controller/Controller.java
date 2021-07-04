package by.training.task04.controller;

import by.training.task04.bean.Account;

import java.util.List;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public int execute(String request) {
        String commandName;
        String idClient;
        String[] params;

        params = request.split("\\s+");
        commandName = params[0];
        idClient = params[1];
        Command currentCommand = provider.getCommand(commandName);
        int response;
        response = currentCommand.executeCommand(idClient);
        return response;
    }

    public List<Account> executeAccount(String request) {
        String commandName;
        String idClient;
        String[] params;

        params = request.split("\\s+");
        commandName = params[0];
        idClient = params[1];
        CommandAccount currentCommand = provider.getCommandAccount(commandName);
        List<Account> response;
        response = currentCommand.executeCommand(idClient);
        return response;
    }

    public int[] executeBalance(String request) {
        String commandName;
        String idClient;
        String[] params;

        params = request.split("\\s+");
        commandName = params[0];
        idClient = params[1];
        CommandBalance currentCommand = provider.getCommandBalance(commandName);
        int[] response;
        response = currentCommand.executeCommand(idClient);
        return response;
    }

    public boolean executeBlock(String request) {
        String commandName;
        String idClient;
        String[] params;

        params = request.split("\\s+");
        commandName = params[0];
        idClient = params[1];
        CommandBlock currentCommand = provider.getCommandBlock(commandName);
        boolean response;
        response = currentCommand.executeCommand(idClient);
        return response;
    }
}
