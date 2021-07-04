package by.training.task04.controller;

import by.training.task04.bean.Account;

import java.util.List;

public interface CommandAccount {
    public List<Account> executeCommand(String idClient);
}
