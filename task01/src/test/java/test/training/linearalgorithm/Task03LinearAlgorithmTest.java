package test.training.linearalgorithm;

import by.training.linearalgorithm.task.Task03LinearAlgorithm;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task03LinearAlgorithmTest {
    Task03LinearAlgorithm task03LinearAlgorithm = new Task03LinearAlgorithm();

    @DataProvider(name = "dataForGetFunctionPositive") //l * l / (4 * Math.PI);
    public Object[][] createPositiveDataForGetFunction() {
        return new Object[][]{
                {new double[]{1}, 0.0796},
                {new double[]{2}, 0.3184},
        };
    }

    @DataProvider(name = "dataForGetMultiply")
    public Object[][] createPositiveDataForGetMultiply() {
        return new Object[][]{
                {new double[]{0, 0},0 },
                {new double[]{-1, 1}, -1},
                {new double[]{1, -1}, -1},
                {new double[]{-1, -1}, 1}
        };
    }

    @Test(description = "Positive scenario of the getMultiply", dataProvider = "dataForGetMultiply")
    public void testGetMultiply(double ab[], double z) {
        double actual = task03LinearAlgorithm.getMultiply(ab[0], ab[1]);
        double expected = z;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(description = "Positive scenario of the getFunction", dataProvider = "dataForGetFunctionPositive")
    public void testGetFunctionPositive(double a[], double z) {
        double actual = task03LinearAlgorithm.getFunction(a[0]);
        double expected = z;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(description = "Negative first scenario of the Calculate",
            enabled = true, expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "It can't be: length of circle is < = 0!")
    public void testNegative1Calculate() throws IllegalArgumentException {
       task03LinearAlgorithm.getFunction(-1);
    }
}
