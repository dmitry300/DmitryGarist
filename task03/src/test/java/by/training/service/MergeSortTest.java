package by.training.service;

import by.training.task03.bean.Array;
import by.training.task03.service.impl.MergeSort;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MergeSortTest {

    MergeSort mergeSort = new MergeSort();

    @DataProvider(name = "dataForSortIncreasing")
    public Object[][] createPositiveDataForSortIncreasing() {
        return new Object[][]{
                {new Array<>(new Double[]{6.0, 20.0, 13.0, 15.0, 2.0, 1.0, 9.0, 30.0, 17.0, 10.0}), new Array<>(new Double[]{1.0, 2.0, 6.0, 9.0, 10.0, 13.0, 15.0, 17.0, 20.0, 30.0})},
                {new Array<>(new Double[]{0.0, 0.0, 0.0, 0.0, 0.0}), new Array<>(new Double[]{0.0, 0.0, 0.0, 0.0, 0.0})},
                {new Array<>(new Double[]{-1.0, -1.0, -1.0, -1.0, -1.0}), new Array<>(new Double[]{-1.0, -1.0, -1.0, -1.0, -1.0})},
                {new Array<>(new Double[]{1.0, 1.0, 1.0, 1.0, 1.0}), new Array<>(new Double[]{1.0, 1.0, 1.0, 1.0, 1.0})}
        };
    }

    @DataProvider(name = "dataForSortDecreasing")
    public Object[][] createPositiveDataForSortDecreasing() {
        return new Object[][]{
                {new Array<>(new Number[]{6.0, 20.0, 13.0, 15.0, 2.0, 1.0, 9.0, 30.0, 17.0, 10.0}), new Array<>(new Number[]{30.0, 20.0, 17.0, 15.0, 13.0, 10.0, 9.0, 6.0, 2.0, 1.0})},
                {new Array<>(new Double[]{0.0, 0.0, 0.0, 0.0, 0.0}), new Array<>(new Double[]{0.0, 0.0, 0.0, 0.0, 0.0})},
                {new Array<>(new Double[]{-1.0, -1.0, -1.0, -1.0, -1.0}), new Array<>(new Double[]{-1.0, -1.0, -1.0, -1.0, -1.0})},
                {new Array<>(new Double[]{1.0, 1.0, 1.0, 1.0, 1.0}), new Array<>(new Double[]{1.0, 1.0, 1.0, 1.0, 1.0})}
        };
    }

    @Test(description = "Positive scenario of the bubble sort(increasing)", dataProvider = "dataForSortIncreasing")
    public void testSortIncreasing(Array<Double> arr, Array<Double> expArr) {
        Array<Double> actualArray = mergeSort.sortIncreasing(arr, 0, arr.getLength() - 1);
        assertEquals(actualArray, expArr);
    }

    @Test(description = "Positive scenario of the bubble sort(decreasing)", dataProvider = "dataForSortDecreasing")
    public void testSortDecreasing(Array<Double> arr, Array<Double> expArr) {
        Array<Double> actualArray = mergeSort.sortDecreasing(arr, 0, arr.getLength() - 1);
        assertEquals(actualArray, expArr);
    }
}