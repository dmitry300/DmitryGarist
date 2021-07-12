package by.training.task04.controller.provider;

import by.training.task04.controller.Controller;

public class ControlProvider {
    private static final ControlProvider instance = new ControlProvider();
    private final Controller controller = new Controller();

    public static ControlProvider getInstance() {
        return instance;
    }

    public Controller getController() {
        return controller;
    }
}
