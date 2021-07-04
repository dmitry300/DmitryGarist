package by.training.task04.service;

import by.training.task04.bean.Account;
import java.util.List;

public interface FindingLoad {
    List<Account> findAccount(int idClient);
}
