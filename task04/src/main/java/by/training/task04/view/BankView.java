package by.training.task04.view;

import by.training.task04.controller.Controller;

public class BankView {
    public void printResponse(String request) {
        Controller controller = new Controller();
        System.out.println(controller.execute(request));
    }
}
