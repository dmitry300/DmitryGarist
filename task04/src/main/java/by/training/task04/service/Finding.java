package by.training.task04.service;

import by.training.task04.bean.Account;
import by.training.task04.bean.Client;

public interface Finding {
    Account[] findAccount(int idClient);
}
