package by.training.task05.controller.impl;


import by.training.task05.controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongRequest implements Command {
    private static final Logger logger = LogManager.getLogger(WrongRequest.class);

    @Override
    public Object executeCommand(String idClient, String fileName) {
        int id = Integer.parseInt(idClient);
        if (id < 0 || id > 5) {
            logger.error("Error event, client with such id doesn't exist!");
            return "Error event, client with such id doesn't exist!";
        } else if (fileName.isEmpty()) {
            logger.error("This file is empty");
            return "This file is empty";
        }
        return null;
    }
}
