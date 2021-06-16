package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.DAOFactory;
import by.training.task03.service.Sorting;

public class SelectionSort implements Sorting {
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
        for (int min = 0; min < array.getLength() - 1; min++) {
            int least = min;
            for (int j = min + 1; j < array.getLength(); j++) {
                if (array.getElement(j).doubleValue() < array.getElement(least).doubleValue()) {
                    least = j;
                }
            }
            array.swap(min, least);
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
        for (int min = 0; min < array.getLength() - 1; min++) {
            int least = min;
            for (int j = min + 1; j < array.getLength(); j++) {
                if (array.getElement(j).doubleValue() > array.getElement(least).doubleValue()) {
                    least = j;
                }
            }
            array.swap(min, least);
        }
        return array;
    }
}
