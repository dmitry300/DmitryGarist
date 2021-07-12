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
import java.util.*;
import java.util.regex.Pattern;

public class ClientDaoImpl implements ClientDao {
    private static final Pattern DELIMITER = Pattern.compile("\\s*;\\s*");
    private static final Logger logger = LogManager.getLogger(ClientDaoImpl.class);

    @Override
    public Bank addClientData(String fileName) {
        List<Client> clients = new LinkedList<>();
        Bank bank = new Bank(clients);
        BufferedReader br = null;
      //  String dir = System.getProperty("by.training.task04resources.data");
        try {
            br = new BufferedReader(new FileReader("C:/Users/KaMo User/IdeaProjects/task04/src/main/resources/data/" + fileName));
            String tmp;
            while ((tmp = br.readLine()) != null) {
                String[] s = tmp.split(String.valueOf(DELIMITER));
                Client client = new Client();
                client.setIdClient(Integer.parseInt(s[1]));
                clients.add(client);
            }

            for (int i = 0; i < clients.size() - 1; i++) { //убираем дублирующих клинетов с одинаковым Id
                for (int j = i; j < clients.size(); j++) {
                    if (clients.get(i).getIdClient() == clients.get(j).getIdClient()) {
                        clients.remove(j);
                    }
                }
            }
            clients.sort(new Comparator<Client>() { // сортируем по возрастанию,
                @Override                           // для удобства чтения данных для них в последующем
                public int compare(Client o1, Client o2) {
                    return o1.getIdClient() - o2.getIdClient();
                }
            });
            bank.setClients(clients); // передаем клиентов сущности банка
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
