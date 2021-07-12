package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

public class NegativeBalanceBankTest {
    NegativeBalanceBank negativeBalanceBank = new NegativeBalanceBank();

    @Test(description = "Positive scenario for calculating negative sum accounts")
    public void testFindTotalBalanceClient() {
        List<Client> clients = new LinkedList<>();
        List<Account> accounts = new LinkedList<>();
        accounts.add(new Account(125));
        accounts.add(new Account(-500));
        accounts.add(new Account(0));
        accounts.add(new Account(-300));
        clients.add(new Client(accounts));
        Bank bank = new Bank(clients);
        int actual = negativeBalanceBank.findTotalBalanceClient(bank);
        int expected = -800;
        assertEquals(actual,expected);
    }
}