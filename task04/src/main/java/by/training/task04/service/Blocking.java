package by.training.task04.service;

import by.training.task04.bean.Bank;

public interface Blocking {
    boolean block(Bank bank,int idAccount);
    boolean unblock(Bank bank, int idAccount);
}
