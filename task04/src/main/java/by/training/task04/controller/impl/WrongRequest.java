package by.training.task04.controller.impl;

import by.training.task04.controller.Command;

public class WrongRequest implements Command {
    @Override
    public Object executeCommand(String idClient, String fileName) {
        int id = Integer.parseInt(idClient);
        if (id < 0 || id > 6) {
            return "Error event, client with such id doesn't exist!";
        } else if (fileName.isEmpty()) {
            return "This file is empty";
        }
        return null;
    }
}
