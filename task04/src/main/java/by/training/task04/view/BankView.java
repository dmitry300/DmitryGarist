package by.training.task04.view;

import by.training.task04.bean.Account;
import by.training.task04.controller.Controller;
import by.training.task04.controller.provider.ControlProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class BankView {
    private static final Logger logger = LogManager.getLogger(BankView.class);
    private final ControlProvider controlProvider = ControlProvider.getInstance();

    public void printResponse(String request) {
        Controller controller = controlProvider.getController();
        logger.info(String.format("Ваш общий баланс составляет: %s", controller.execute(request)));
        System.out.println("Ваш общий баланс составляет:" + controller.execute(request));
    }

    public void printResponseAccount(String request) {
        Controller controller = controlProvider.getController();
        for (Account account : (List<Account>) controller.execute(request)) {
            logger.info(String.format("Счета клиента по его запросу %s", account.toString()));
            System.out.println(account);
        }
    }

    public void printResponseBalance(String request) {
        Controller controller = controlProvider.getController();
        List<Integer> listBalance = new LinkedList<>((List<Integer>) controller.execute(request));
        System.out.println("Ваш положительный бюджет составляет: " + listBalance.get(0));
        System.out.println("Ваш отрицательный бюджет составляет: " + listBalance.get(1));
        logger.info(String.format("[сумма счетов с пол. балансом, сумма счетов с отр. балансом]: %s", listBalance));
    }

    public void printResponseBlock(String request) {
        Controller controller = controlProvider.getController();
        if ((boolean) controller.execute(request)) {
            System.out.println("Ваш аккаунт теперь имеет статус: РАЗБЛАКИРОВАННО");
            logger.info("Ваш аккаунт теперь имеет статус: РАЗБЛАКИРОВАННО");
        } else {
            System.out.println("Ваш аккаунт теперь имеет статус: ЗАБЛАКИРОВАННО");
            logger.info("Ваш аккаунт теперь имеет статус: ЗАБЛАКИРОВАННО");
        }

    }
}
