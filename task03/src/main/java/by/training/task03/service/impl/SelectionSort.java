package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.service.Sorting;

public class SelectionSort implements Sorting {

    /**
     * @param array
     * @return sorted array
     */
    @Override
    public Array<Double> sortIncreasing(Array<Double> array) {
        for (int min = 0; min < array.getLength() - 1; min++) {
            int least = min;
            for (int j = min + 1; j < array.getLength(); j++) {
                if (array.getElement(j) < array.getElement(least)) {
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
    public Array<Double> sortDecreasing(Array<Double> array) {
        for (int min = 0; min < array.getLength() - 1; min++) {
            int least = min;
            for (int j = min + 1; j < array.getLength(); j++) {
                if (array.getElement(j) > array.getElement(least)) {
                    least = j;
                }
            }
            array.swap(min, least);
        }
        return array;
    }
}
