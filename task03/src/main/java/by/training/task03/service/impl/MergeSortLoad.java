package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.DAOFactory;
import by.training.task03.service.SortingLoad;

public class MergeSortLoad implements SortingLoad {
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private final ArrayDao arrayDao = daoFactory.getFileArrayDao();
    private final Array<Double> array = arrayDao.saveArray("C:/Users/KaMo User/IdeaProjects/demomatrix/src/data/dataForArray.txt");

    @Override
    public Array<Double> sortIncreasing() {
        return new MergeSort().sortIncreasing(array, 0, array.getLength() - 1);
    }

    @Override
    public Array<Double> sortDecreasing() {
        return new MergeSort().sortDecreasing(array, 0, array.getLength() - 1);
    }
}
