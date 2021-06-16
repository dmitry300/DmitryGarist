package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.DAOFactory;
import by.training.task03.service.Sorting;

public class ShellSort implements Sorting {
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
        int inner, outer;

        Number temp;

        int h = 1;
        while (h <= array.getLength() / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < array.getLength(); outer++) {
                temp = array.getElement(outer);
                inner = outer;

                while (inner > h - 1 && array.getElement(inner - h).doubleValue() >= temp.doubleValue()) {
                    array.setElement(inner, array.getElement(inner - h));
                    inner -= h;
                }
                array.setElement(inner, temp);
            }
            h = (h - 1) / 3;
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
        int inner, outer;
        Number temp;

        int h = 1;
        while (h <= array.getLength() / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < array.getLength(); outer++) {
                temp = array.getElement(outer);
                inner = outer;

                while (inner > h - 1 && array.getElement(inner - h).doubleValue() <= temp.doubleValue()) {
                    array.setElement(inner, array.getElement(inner - h));
                    inner -= h;
                }
                array.setElement(inner, temp);
            }
            h = (h - 1) / 3;
        }
        return array;
    }
}
