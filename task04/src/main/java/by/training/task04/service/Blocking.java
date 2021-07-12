package by.training.task04.service;

import by.training.task04.bean.Bank;

public interface Blocking {
    Boolean block(Bank bank,int idAccount);
    Boolean unblock(Bank bank, int idAccount);
}
