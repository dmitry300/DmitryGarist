package by.training.task04.view;

import by.training.task04.bean.Account;
import by.training.task04.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class BankView {
    private static final Logger logger = LogManager.getLogger(BankView.class);

    public void printResponse(String request) {
        Controller controller = new Controller();
        logger.info(String.format("Ваш общий баланс составляет: %s", controller.execute(request)));
        System.out.println("Ваш общий баланс составляет:" + controller.execute(request));
    }

    public void printResponseAccount(String request) {
        Controller controller = new Controller();
        for (Account account : controller.executeAccount(request)) {
            logger.info(String.format("Счета клиента по его запросу %s", account.toString()));
            System.out.println(account.toString());
        }
    }

    public void printResponseBalance(String request) {
        Controller controller = new Controller();
        System.out.println("Ваш положительный бюджет составляет: " + controller.executeBalance(request)[0]);
        System.out.println("Ваш отрицательный бюджет составляет: " + controller.executeBalance(request)[1]);
        logger.info(String.format("[сумма счетов с пол. балансом, сумма счетов с отр. балансом]: %s", Arrays.toString(controller.executeBalance(request))));
    }

    public void printResponseBlock(String request) {
        Controller controller = new Controller();
        if (controller.executeBlock(request)) {
            System.out.println("Ваш аккаунт теперь имеет статус: РАЗБЛАКИРОВАННО");
            logger.info("Ваш аккаунт теперь имеет статус: РАЗБЛАКИРОВАННО");
        } else {
            System.out.println("Ваш аккаунт теперь имеет статус: ЗАБЛАКИРОВАННО");
            logger.info("Ваш аккаунт теперь имеет статус: ЗАБЛАКИРОВАННО");
        }

    }
}
