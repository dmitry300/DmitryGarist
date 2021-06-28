package by.training.task03.service.impl;

import by.training.task03.bean.Array;
import by.training.task03.service.Sorting;

public class InsertionHashSort implements Sorting {
    @Override
    public Array<Double> sortIncreasing(Array<Double> array) {
        Double maxValue = array.getElement(0);

        for (int k = 1; k < array.getLength(); k++) {
            if (array.getElement(k) > maxValue)
                maxValue = array.getElement(k);
        }
        //создадим вспомогательный массив
        Array<Double> bucket = new Array<>(Double.class, maxValue.intValue() + 1);
        //распределим числа по карманам
        for (int i = 0; i < array.getLength(); i++) {
            double el = bucket.getElement(i);
            bucket.setElement(i, array.getElement(i));
        }
        for (int left = 1; left < bucket.getLength(); left++) {
            Double value = bucket.getElement(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < bucket.getElement(i)) {
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

    @Override
    public Array<Double> sortDecreasing(Array<Double> array) {
        Double maxValue = array.getElement(0);

        for (int k = 1; k < array.getLength(); k++) {
            if (array.getElement(k) > maxValue)
                maxValue = array.getElement(k);
        }
        //создадим вспомогательный массив
        Array<Double> bucket = new Array<>(Double.class, maxValue.intValue() + 1);
        //распределим числа по карманам
        for (int i = 0; i < array.getLength(); i++) {
            double el = bucket.getElement(array.getElement(i).intValue());
            bucket.setElement(array.getElement(i).intValue(), el++);
        }
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
