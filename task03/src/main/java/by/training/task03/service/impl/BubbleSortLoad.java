package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.DAOFactory;
import by.training.task03.service.SortingLoad;

public class BubbleSortLoad implements SortingLoad {
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private  ArrayDao arrayDao = daoFactory.getFileArrayDao();
    private  Array<Double> array = arrayDao.saveArray("C:/Users/KaMo User/IdeaProjects/demomatrix/src/data/dataForArray.txt");

    @Override
    public Array<Double> sortIncreasing() {
        return new BubbleSort().sortIncreasing(array);
    }

    @Override
    public Array<Double> sortDecreasing() {
        return new BubbleSort().sortDecreasing(array);
    }
}
