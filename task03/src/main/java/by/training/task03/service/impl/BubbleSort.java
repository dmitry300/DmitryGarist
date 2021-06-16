package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.DAOFactory;
import by.training.task03.service.Sorting;

public class BubbleSort implements Sorting {
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    /**
     * @param array
     * @return sorted array
     */
    @Override
    public Array<Number> sortIncreasing(Array<Number> array) {
        if (array == null) {
            ArrayDao arrayDao = daoFactory.getFileArrayDao();
            array = arrayDao.saveArray();
        }
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 0; i < array.getLength() - 1; i++) {
                if (array.getElement(i).doubleValue() > array.getElement(i + 1).doubleValue()) {
                    array.swap(i, i + 1);
                    needIteration = true;
                }
            }
        }
        return array;
    }

    /**
     * @param array
     * @return sorted array
     */
    @Override
    public Array<Number> sortDecreasing(Array<Number> array) {
        if (array == null) {
            ArrayDao arrayDao = daoFactory.getFileArrayDao();
            array = arrayDao.saveArray();
        }
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 0; i < array.getLength() - 1; i++) {
                if (array.getElement(i).doubleValue() < array.getElement(i + 1).doubleValue()) {
                    array.swap(i, i + 1);
                    needIteration = true;
                }
            }
        }
        return array;
    }
}

