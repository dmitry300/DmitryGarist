package by.training.task04.view;

import by.training.task04.bean.Account;
import by.training.task04.controller.Controller;

public class BankView {
    public void printResponse(String request) {
        Controller controller = new Controller();
        System.out.println("Ваш общий баланс составляет:" + controller.execute(request));
    }

    public void printResponseAccount(String request) {
        Controller controller = new Controller();
        for (Account account : controller.executeAccount(request)) {
            System.out.println(account.toString());
        }
    }

    public void printResponseBalance(String request) {
        Controller controller = new Controller();
        System.out.println("Ваш положительный бюджет составляет: " + controller.executeBalance(request)[0]);
        System.out.println("Ваш отрицательный бюджет составляет: " + controller.executeBalance(request)[1]);
    }

    public void printResponseBlock(String request) {
        Controller controller = new Controller();
        System.out.println("Ваш аккаунт тепрь имеет статус " + controller.executeBlock(request));
    }
}
