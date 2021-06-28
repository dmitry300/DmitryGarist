package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.service.Sorting;

public class ShellSort implements Sorting {

    /**
     * @param array
     * @return sorted array
     */
    @Override
    public Array<Double> sortIncreasing(Array<Double> array) {
        int inner;
        int outer;

        Double temp;

        int h = 1;
        while (h <= array.getLength() / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < array.getLength(); outer++) {
                temp = array.getElement(outer);
                inner = outer;

                while (inner > h - 1 && array.getElement(inner - h) >= temp) {
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
    public Array<Double> sortDecreasing(Array<Double> array) {
        int inner;
        int outer;
        Double temp;

        int h = 1;
        while (h <= array.getLength() / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < array.getLength(); outer++) {
                temp = array.getElement(outer);
                inner = outer;

                while (inner > h - 1 && array.getElement(inner - h) <= temp) {
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
