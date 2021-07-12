package by.training.task04.controller.main;

import by.training.task04.view.BankView;

/**
 * @author Dmitry Garist
 * Task04: 4.	Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки/разблокировки счета.
 * Реализовать поиск и сортировку счетов и т.д.
 * Вычисление общей суммы по счетам.
 * Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

public class Main {
    public static void main(String[] args) {
        String fileName = "dataForAccount.txt";
        BankView bankView = new BankView();
        bankView.printResponseBalance(String.format("positive_negative_sum_client, 1, %s", fileName));
        bankView.printResponse(String.format("total_balance_client, 1, %s", fileName));
        bankView.printResponseAccount(String.format("sort_client_account, 1, %s", fileName));
        bankView.printResponseBlock(String.format("block_account, 1, %s", fileName));
    }
}
