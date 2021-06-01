package test.training.linearalgorithm;

import by.training.linearalgorithm.task.Task05LinearAlgorithm;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task05LinearAlgorithmTest {
    Task05LinearAlgorithm task05LinearAlgorithm = new Task05LinearAlgorithm();

    @DataProvider(name = "dataForGetFunctionPositive")
    public Object[][] createPositiveDataForGetFunction() {
        return new Object[][]{
                {1111, new int[]{1, 1}},
                {1234, new int[]{8, 3}},
                {2222, new int[]{16, 1}},
                {3333, new int[]{1, 81}}
        };
    }


    @Test(description = "Positive scenario of the getFunction", dataProvider = "dataForGetFunctionPositive")
    public void testGetFunction(int a, int[] array) {
        int[] actual = task05LinearAlgorithm.function(a);
        int[] expected = array;
        assertEquals(actual, expected);
    }


}
