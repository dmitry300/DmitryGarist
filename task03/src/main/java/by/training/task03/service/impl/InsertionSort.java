package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.DAOFactory;
import by.training.task03.service.Sorting;

public class InsertionSort implements Sorting {
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
        for (int left = 1; left < array.getLength(); left++) {
            Number value = array.getElement(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value.doubleValue() < array.getElement(i).doubleValue()) {
                    array.setElement(i + 1, array.getElement(i));
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            array.setElement(i + 1, value);
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
        for (int left = 1; left < array.getLength(); left++) {
            Number value = array.getElement(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value.doubleValue() > array.getElement(i).doubleValue()) {
                    array.setElement(i + 1, array.getElement(i));
                } else {
                    // Если вытащенный элемент меньше — останавливаемся
                    break;
                }
            }
            array.setElement(i + 1, value);
        }
        return array;
    }
}