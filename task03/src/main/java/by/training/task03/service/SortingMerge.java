package by.training.task03.service;

import by.training.task03.bean.Array;

public interface SortingMerge {
    Array<Double> sortIncreasing(Array<Double> array, int left, int right);

    Array<Double> sortDecreasing(Array<Double> array, int left, int right);
}

