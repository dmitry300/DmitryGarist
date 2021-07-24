package by.training.task06.controller.impl;

import by.training.task06.controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongRequest implements Command {
    private static final Logger logger = LogManager.getLogger(WrongRequest.class);

    @Override
    public void executeCommand(String fileNameForMatrix, String fileNameForThread) {
        if (fileNameForMatrix.isEmpty()|| fileNameForThread.isEmpty()) {
            logger.error("This file(s) is empty");
        }
    }
}
