package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.DAOFactory;
import by.training.task03.service.Sorting;

public class ShakerSort implements Sorting {
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
        int left = 0;
        int right = array.getLength() - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array.getElement(i).doubleValue() > array.getElement(i + 1).doubleValue()) {
                    array.swap(i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array.getElement(i).doubleValue() < array.getElement(i - 1).doubleValue()) {
                    array.swap(i, i - 1);
                }
            }
            left++;
        } while (left < right);
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
        int left = 0;
        int right = array.getLength() - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array.getElement(i).doubleValue() < array.getElement(i + 1).doubleValue()) {
                    array.swap(i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array.getElement(i).doubleValue() > array.getElement(i - 1).doubleValue()) {
                    array.swap(i, i - 1);
                }
            }
            left++;
        } while (left < right);
        return array;
    }
}
