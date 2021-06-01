package test.training.linearalgorithm;

import by.training.linearalgorithm.task.Task02LinearAlgorithm;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task02LinearAlgorithmTest {
    Task02LinearAlgorithm task02LinearAlgorithm = new Task02LinearAlgorithm();

    @DataProvider(name = "dataForGetPowX") //Math.pow((x2 - x1), 2);
    public Object[][] createPositiveDataForGetPowX() {
        return new Object[][]{
                {new double[]{0, 0}, 0},
                {new double[]{-1, 1}, 4},
                {new double[]{1, -1}, 4},
                {new double[]{2.5, 1.2}, 1.69}
        };
    }

    @DataProvider(name = "dataForGetPowY")
    public Object[][] createPositiveDataForGetPowY() {
        return new Object[][]{
                {new double[]{0, 0}, 0},
                {new double[]{-1, 1}, 4},
                {new double[]{1, -1}, 4},
                {new double[]{2.5, 1.2}, 1.69}
        };
    }

    @DataProvider(name = "dataForGetDifferenceX")//x2 - x1
    public Object[][] createPositiveDataForGetDifferenceX() {
        return new Object[][]{
                {new double[]{0, 0}, 0},
                {new double[]{1, -2}, -3},
                {new double[]{-1, 2}, 3},
                {new double[]{3.4, 5.7}, 2.3}
        };
    }

    @DataProvider(name = "dataForGetDifferenceY")
    public Object[][] createPositiveDataForGetDifferenceY() {
        return new Object[][]{
                {new double[]{0, 0}, 0},
                {new double[]{1, -2}, -3},
                {new double[]{-1, 2}, 3},
                {new double[]{3.4, 5.7}, 2.3}
        };
    }

    @DataProvider(name = "dataForGetFunction") //Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)
    public Object[][] createPositiveDataForGetFunction() {
        return new Object[][]{
                {new double[]{0, 0, 0, 0}, 0},
                {new double[]{-1, -1, -2, -2}, 0},
                {new double[]{1, 1, 2, 2}, 0},
                {new double[]{1.5, 1.5, 2.5, 4}, 1.5}
        };
    }

    @Test(description = "Positive scenario of the getDifferenceX", dataProvider = "dataForGetDifferenceX")
    public void testGetDifferenceX(double ab[], double z) {
        double actual = task02LinearAlgorithm.differenceX(ab[0], ab[1]);
        double expected = z;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(description = "Positive scenario of the getDifferenceY", dataProvider = "dataForGetDifferenceY")
    public void testGetDifferenceY(double ab[], double z) {
        double actual = task02LinearAlgorithm.differenceY(ab[0], ab[1]);
        double expected = z;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(description = "Positive scenario of the getFunction", dataProvider = "dataForGetFunction")
    public void testGetFunction(double abcd[], double z) {
        double actual = task02LinearAlgorithm.function(abcd[0], abcd[1], abcd[2], abcd[3]);
        double expected = z;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(description = "Positive scenario of the getPowX", dataProvider = "dataForGetPowX")
    public void testGetPowX(double ab[], double z) {
        double actual = task02LinearAlgorithm.powX(ab[0], ab[1]);
        double expected = z;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(description = "Positive scenario of the getPowY", dataProvider = "dataForGetPowY")
    public void testGetPowY(double ab[], double z) {
        double actual = task02LinearAlgorithm.powY(ab[0], ab[1]);
        double expected = z;
        assertEquals(actual, expected, 0.0001);
    }
}
