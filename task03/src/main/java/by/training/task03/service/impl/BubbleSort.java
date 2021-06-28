package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.service.Sorting;

public class BubbleSort implements Sorting {
    /**
     * @param array
     * @return sorted array
     */
    @Override
    public Array<Double> sortIncreasing(Array<Double> array) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 0; i < array.getLength() - 1; i++) {
                if (array.getElement(i) > array.getElement(i + 1)) {
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
    public Array<Double> sortDecreasing(Array<Double> array) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 0; i < array.getLength() - 1; i++) {
                if (array.getElement(i)< array.getElement(i + 1)) {
                    array.swap(i, i + 1);
                    needIteration = true;
                }
            }
        }
        return array;
    }
}

