package by.training.task04.dao.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import by.training.task04.dao.AccountDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Integers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class AccountDaoImpl implements AccountDao {
    private static final Pattern DELIMITER = Pattern.compile("\\s*;\\s*");
    private static final Logger logger = LogManager.getLogger(AccountDaoImpl.class);

    @Override
    public Bank addAccountData(String fileName) {
        List<Account> accounts = new LinkedList<>();
        ClientDaoImpl clientDao = new ClientDaoImpl();
        Bank bank = clientDao.addClientData(fileName); // отдельный метод для загрузки клиентов
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String tmp;
            for (Client client : bank.getClients()) {
                while ((tmp = br.readLine()) != null) {
                    String[] s = tmp.split(String.valueOf(DELIMITER));
                    if (Integers.parseInt(s[1]) == client.getIdClient()) {
                        Account account = new Account();
                        account.setIdAccount(Integer.parseInt(s[0]));
                        account.setBalance(Integer.parseInt(s[2]));
                        account.setAccountStatus(Boolean.parseBoolean(s[3]));
                        accounts.add(account);
                    }
                }
                client.setAccounts(accounts);
            }
        } catch (
                IOException e) {
            logger.error(String.format("Error reading file %s", e));
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }
        return bank;
    }
}
