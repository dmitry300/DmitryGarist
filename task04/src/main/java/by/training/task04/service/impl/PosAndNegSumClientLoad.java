package by.training.task04.service.impl;

import by.training.task04.bean.Bank;
import by.training.task04.dao.DAOFactory;
import by.training.task04.service.SeparateSum;
import by.training.task04.service.SeparateSumLoad;


public class PosAndNegSumClientLoad implements SeparateSumLoad {
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private final Bank bank = daoFactory.getBankDao().addAccountData("C:/Users/KaMo User/IdeaProjects/task04/src/main/java/by/training/task04/data/dataForAccount.txt");

    @Override
    public int[] separateSum(int idClient) {

        return new PosAndNegSumClient().separateSum(bank, idClient);
    }
}
