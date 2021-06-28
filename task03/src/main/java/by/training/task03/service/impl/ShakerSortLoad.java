package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.DAOFactory;
import by.training.task03.service.SortingLoad;

public class ShakerSortLoad implements SortingLoad {
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private final ArrayDao arrayDao = daoFactory.getFileArrayDao();
    private final Array<Double> array = arrayDao.saveArray("C:/Users/KaMo User/IdeaProjects/demomatrix/src/data/dataForArray.txt");

    @Override
    public Array<Double> sortIncreasing() {
        return new ShakerSort().sortIncreasing(array);
    }

    @Override
    public Array<Double> sortDecreasing() {
        return new ShakerSort().sortDecreasing(array);
    }
}
