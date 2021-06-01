package test.training.linearalgorithm;

import by.training.linearalgorithm.task.Task01LinearAlgorithm;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Task01LinearAlgorithmTest {
    Task01LinearAlgorithm task01LinearAlgorithm = new Task01LinearAlgorithm();

    @DataProvider(name = "dataForGetMultiply")
    public Object[][] createPositiveDataForGetMultiply() {
        return new Object[][]{
                {new double[]{0, 0}, 0},
                {new double[]{-1, -30}, 30},
                {new double[]{-1, 30}, -30},
                {new double[]{3.4, 5.7}, 19.38}
        };
    }

    @DataProvider(name = "dataForGetSum")
    public Object[][] createPositiveDataForGetSum() {
        return new Object[][]{
                {new double[]{0, 0}, 0},
                {new double[]{-1, -30}, -31},
                {new double[]{20, 40}, 60},
                {new double[]{3.4, 5.7}, 9.1}
        };
    }

    @DataProvider(name = "dataForGetDifference")
    public Object[][] createPositiveDataForGetDifference() {
        return new Object[][]{
                {new double[]{0, 0}, 0},
                {new double[]{1, -2}, 3},
                {new double[]{20, 40}, -20},
                {new double[]{3.4, 5.7}, -2.3}
        };
    }

    @DataProvider(name = "dataForGetExpression")
    public Object[][] createPositiveDataForGetExpression() {
        return new Object[][]{
                {new double[]{0, 0, 0}, 0},
                {new double[]{-1, -30, 20}, 80},
                {new double[]{20, 40, 10}, 350},
                {new double[]{3.4, 5.7, 8.1}, 9.24}
        };
    }


    @Test(description = "Positive scenario of the getSum", dataProvider = "dataForGetSum")
    public void testGetSum(double ab[], double z) {
        double actual = task01LinearAlgorithm.sum(ab[0], ab[1]);
        double expected = z;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(description = "Positive scenario of the getDifference", dataProvider = "dataForGetDifference")
    public void testGetDifference(double ab[], double z) {
        double actual = task01LinearAlgorithm.difference(ab[0], ab[1]);
        double expected = z;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(description = "Positive scenario of the getExpression", dataProvider = "dataForGetExpression")
    public void testGetDivision(double abc[], double z) {
        double actual = task01LinearAlgorithm.expression(abc[0], abc[1], abc[2]);
        double expected = z;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(description = "Positive scenario of the getMultiply", dataProvider = "dataForGetMultiply")
    public void testGetMultiply(double ab[], double z) {
        double actual = task01LinearAlgorithm.multiply(ab[0], ab[1]);
        double expected = z;
        assertEquals(actual, expected, 0.0001);
    }
}
//в формуле деления входного параметра на другой - нет, соответсвенно и теста.
