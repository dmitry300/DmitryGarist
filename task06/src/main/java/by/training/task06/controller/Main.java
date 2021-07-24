package by.training.task06.controller;

import by.training.task06.service.exception.ServiceException;
import by.training.task06.service.impl.ConsoleReader;
import by.training.task06.view.MenuPrint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logg = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MenuPrint menuPrint = new MenuPrint();
        Controller controller = new Controller();
        menuPrint.menu();
        boolean isEnable = true;
        int userChoose = 0;
        try {
            userChoose = new ConsoleReader().consoleReader(">> ");
        } catch (ServiceException e) {
            logg.error("Error reading number, " + e);
        }
        try {
            while (isEnable) {
                switch (userChoose) {
                    case 1: {
                        controller.execute("locker, matrix, thread");
                        break;
                    }
                    case 2: {
                        controller.execute("semaphore, matrix, thread");
                        break;
                    }
                    case 3: {
                        controller.execute("phaser, matrix, thread");
                        break;
                    }
                    case 4: {
                        controller.execute("cyclic_barrier, matrix, thread");
                        break;
                    }
                    case 0: {
                        isEnable = false;
                        break;
                    }
                    default: {
                        throw new IllegalStateException("Unexpected value: " + userChoose);
                    }
                }
            }
        } catch (IllegalStateException e) {
            logg.error("Incorrect choice");
        }
    }
}
