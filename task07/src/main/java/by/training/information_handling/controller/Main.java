package by.training.information_handling.controller;

import by.training.information_handling.bean.Composite;
import by.training.information_handling.bean.Text;
import by.training.information_handling.dao.exception.DaoException;
import by.training.information_handling.dao.provider.DaoProvider;
import by.training.information_handling.service.ChainParser;

public class Main {
    public static void main(String[] args) throws DaoException {
        DaoProvider daoProvider = DaoProvider.getInstance();
        String str = daoProvider.getTextDao().saveText("data/text");
        System.out.println(str);
        System.out.println();
       // Text text = new Text();
        ChainParser chainParser = new ChainParser();
        Composite composite = chainParser.parse(str);
        System.out.println(composite);
       // System.out.println(chainParser.collectText());
        //System.out.println(paragraph);

    }
}
