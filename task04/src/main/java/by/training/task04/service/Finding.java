package by.training.task04.service;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;

import java.util.List;

public interface Finding {
    List<Account> findAccount(Bank bank, int idClient);
}
