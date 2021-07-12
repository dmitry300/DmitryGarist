package by.training.task04.service.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BlockAccountTest {
    BlockAccount blockAccount = new BlockAccount();

//    @DataProvider(name = "dataForBlock")
//    public Object[][] createPositiveDataForBlock() {
//        List<Client> clients = new LinkedList<>();
//        List<Account> accounts = new LinkedList<>();
//        accounts.add(new Account(true));
//        clients.add(new Client(accounts, 1));
//        Bank bank = new Bank(clients);
//        return new Object[][]{
//                {bank}
//        };
//    }

        @Test(description = "Positive scenario for blocking account")
        public void testBlock () {
            List<Client> clients = new LinkedList<>();
            List<Account> accounts = new LinkedList<>();
            accounts.add(new Account(true));
            clients.add(new Client(accounts, 1));
            Bank bank = new Bank(clients);
            boolean actual = blockAccount.block(bank, 1);
            boolean expected = false;
            assertEquals(actual, expected);
        }

        @Test(description = "Positive scenario for unblocking account")
        public void testUnblock () {
            List<Client> clients = new LinkedList<>();
            List<Account> accounts = new LinkedList<>();
            accounts.add(new Account(false));
            clients.add(new Client(accounts, 1));
            Bank bank = new Bank(clients);
            boolean actual = blockAccount.unblock(bank, 1);
            boolean expected = true;
            assertEquals(actual, expected);
        }
    }