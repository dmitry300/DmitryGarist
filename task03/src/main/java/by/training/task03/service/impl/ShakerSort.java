package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.service.Sorting;

public class ShakerSort implements Sorting {

    /**
     * @param array
     * @return sorted array
     */
    @Override

    public Array<Double> sortIncreasing(Array<Double> array) {
        int left = 0;
        int right = array.getLength() - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array.getElement(i) > array.getElement(i + 1)) {
                    array.swap(i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array.getElement(i) < array.getElement(i - 1)) {
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
    public Array<Double> sortDecreasing(Array<Double> array) {
        int left = 0;
        int right = array.getLength() - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array.getElement(i) < array.getElement(i + 1)) {
                    array.swap(i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array.getElement(i) > array.getElement(i - 1)) {
                    array.swap(i, i - 1);
                }
            }
            left++;
        } while (left < right);
        return array;
    }
}
