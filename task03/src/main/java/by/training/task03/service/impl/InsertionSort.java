package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.service.Sorting;

public class InsertionSort implements Sorting {
    /**
     * @param array
     * @return sorted array
     */
    @Override
    public Array<Double> sortIncreasing(Array<Double> array) {
        for (int left = 1; left < array.getLength(); left++) {
            Double value = array.getElement(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array.getElement(i)) {
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
    public Array<Double> sortDecreasing(Array<Double> array) {
        for (int left = 1; left < array.getLength(); left++) {
            Double value = array.getElement(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value > array.getElement(i)) {
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