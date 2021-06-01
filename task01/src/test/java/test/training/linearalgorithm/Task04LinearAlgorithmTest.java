package test.training.linearalgorithm;

import by.training.linearalgorithm.task.Task04LinearAlgorithm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task04LinearAlgorithmTest {
    Task04LinearAlgorithm task04LinearAlgorithm = new Task04LinearAlgorithm();

    @DataProvider(name = "dataForGetFunctionPositive") //l * l / (4 * Math.PI);
    public Object[][] createPositiveDataForGetFunction() {
        return new Object[][]{
                {1, new double[]{57, 17, 44}},
                {2, new double[]{114, 35, 29}},
                {0, new double[]{0, 0, 0}}
        };
    }


    @Test(description = "Positive scenario of the getFunction", dataProvider = "dataForGetFunctionPositive")
    public void testGetFunction(double a, double[] z) {
        double[] actual = task04LinearAlgorithm.function(a);
        double[] expected = z;
        assertEquals(actual, expected);
    }


}

