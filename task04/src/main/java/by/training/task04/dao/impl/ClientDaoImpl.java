package by.training.task04.dao.impl;

import by.training.task04.bean.Account;
import by.training.task04.bean.Bank;
import by.training.task04.bean.Client;
import by.training.task04.dao.ClientDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class ClientDaoImpl implements ClientDao {
    private static final Pattern DELIMITER = Pattern.compile("\\s*;\\s*");
    private static final Logger logger = LogManager.getLogger(ClientDaoImpl.class);

    @Override
    public Bank addClientData(String fileName) {
        List<Client> clients = new LinkedList<>();
        Bank bank = new Bank(clients);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:/Users/KaMo User/IdeaProjects/task04/src/main/java/by/training/task04/data/dataForAccount.txt"));
            String tmp;

            while ((tmp = br.readLine()) != null) {
                Client client = new Client();
                String[] s = tmp.split(String.valueOf(DELIMITER));
                client.setIdClient(Integer.parseInt(s[1]));
                clients.add(client);
            }

//            Set<Client> set = new LinkedHashSet<>(clients);
//            clients.clear();
//            clients.addAll(set);
            for (Client i : clients) {
                logger.info(i.toString());
            }

            for (int i = 0; i < clients.size() - 1; i++) {
                for (int j = i; j < clients.size(); j++) {
                    if (clients.get(i).getIdClient() == clients.get(j).getIdClient()) {
                        clients.remove(j);
                    }
                }
            }

            for (Client client : clients) {
                logger.info(client.toString());
            }

            bank.setClients(clients);
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
