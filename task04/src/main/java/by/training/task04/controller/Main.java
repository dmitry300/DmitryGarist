package by.training.task04.controller;

import by.training.task04.view.BankView;

public class Main {
    public static void main(String[] args) {
        BankView bankView = new BankView();
        bankView.printResponseBalance("positive_negative_sum_client 1");
        bankView.printResponse("total_balance_client 1");
        bankView.printResponseAccount("sort_client_account 1");
        bankView.printResponseBlock("block_account 1");
    }
}
