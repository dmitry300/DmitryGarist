package by.training.task04.dao.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import by.training.task04.dao.BankDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class AccountDaoImpl implements BankDao {
    private static final Pattern DELIMITER = Pattern.compile("\\s*;\\s*");
    private static final Logger logger = LogManager.getLogger(AccountDaoImpl.class);

    @Override
    public Bank addAccount() {
        Client[] client = new Client[6];
        Account[] accounts = new Account[10];
        Bank bank = new Bank();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:/Users/KaMo User/IdeaProjects/task04/src/main/java/by/training/task04/data/dataForAccount.txt"));
            String tmp;
            while ((tmp = br.readLine()) != null) {
                String[] s = tmp.split(String.valueOf(DELIMITER));
                for (Client i : client ) {
                    i.setIdClient(Integer.parseInt(s[1]));
                    for (Account j : i.getAccounts()) {
                        j.setIdAccount(Integer.parseInt(s[0]));
                        j.setBalance(Integer.parseInt(s[2]));
                        j.setAccountStatus(Boolean.parseBoolean(s[3]));
                    }
                }
            }
        } catch (IOException e) {
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
