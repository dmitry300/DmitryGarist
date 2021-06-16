package by.training.service;

import by.training.task03.bean.Array;
import by.training.task03.service.impl.SelectionSort;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SelectionSortTest {
    SelectionSort selectionSort = new SelectionSort();

    @DataProvider(name = "dataForSortIncreasing")
    public Object[][] createPositiveDataForSortIncreasing() {
        return new Object[][]{
                {new Array<>(new Number[]{6, 20, 13, 15, 2, 1, 9, 30, 17, 10}), new Array<>(new Number[]{1, 2, 6, 9, 10, 13, 15, 17, 20, 30})},
                {new Array<>(new Number[]{0, 0, 0, 0, 0}), new Array<>(new Number[]{0, 0, 0, 0, 0})},
                {new Array<>(new Number[]{-1, -1, -1, -1, -1}), new Array<>(new Number[]{-1, -1, -1, -1, -1})},
                {new Array<>(new Number[]{1, 1, 1, 1, 1}), new Array<>(new Number[]{1, 1, 1, 1, 1})}
        };
    }

    @DataProvider(name = "dataForSortDecreasing")
    public Object[][] createPositiveDataForSortDecreasing() {
        return new Object[][]{
                {new Array<>(new Number[]{6, 20, 13, 15, 2, 1, 9, 30, 17, 10}), new Array<>(new Number[]{30, 20, 17, 15, 13, 10, 9, 6, 2, 1})},
                {new Array<>(new Number[]{0, 0, 0, 0, 0}), new Array<>(new Number[]{0, 0, 0, 0, 0})},
                {new Array<>(new Number[]{-1, -1, -1, -1, -1}), new Array<>(new Number[]{-1, -1, -1, -1, -1})},
                {new Array<>(new Number[]{1, 1, 1, 1, 1}), new Array<>(new Number[]{1, 1, 1, 1, 1})}
        };
    }

    @Test(description = "Positive scenario of the bubble sort(increasing)", dataProvider = "dataForSortIncreasing")
    public void testSortIncreasing(Array arr, Array expArr) {
        arr = selectionSort.sortIncreasing(arr);
        Array expected = expArr;
        assertEquals(arr, expected);
    }

    @Test(description = "Positive scenario of the bubble sort(decreasing)", dataProvider = "dataForSortDecreasing")
    public void testSortDecreasing(Array arr, Array expArr) {
        arr = selectionSort.sortDecreasing(arr);
        Array expected = expArr;
        assertEquals(arr, expected);
    }

}
