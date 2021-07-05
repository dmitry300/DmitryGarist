package by.training.task04.controller;

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
        BankView bankView = new BankView();
        bankView.printResponseBalance("positive_negative_sum_client 1");
        bankView.printResponse("total_balance_client 1");
        bankView.printResponseAccount("sort_client_account 2");
        bankView.printResponseBlock("block_account 1");
    }
}
