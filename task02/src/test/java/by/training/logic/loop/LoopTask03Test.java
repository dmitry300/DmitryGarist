package by.training.logic.loop;

import by.training.logic.loop.LoopTask03;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoopTask03Test {
    LoopTask03 loopTask03 = new LoopTask03();

    @DataProvider(name = "dataForGetSumMembersOfNumbers")
    public Object[][] createPositiveDataForGetSumMembersOfNumbers() {
        return new Object[][]{
                {new double[]{0}, 0.3333},
                {new double[]{0.2}, 0.2857},
                {new double[]{0.00001}, 0.3322},
                {new double[]{-1}, 0.3333},
                {new double[]{-10}, 0.3333},
                {new double[]{1}, 0},
        };
    }

    @Test(description = "Positive scenario of the SumMembersOfNumbers", dataProvider = "dataForGetSumMembersOfNumbers")
    public void testSumMembersOfNumbers(double a[], double value) {
        double actual = loopTask03.sumMembersOfNumbers(a[0]);
        double expected = value;
        assertEquals(actual, expected, 0.0001);
    }
}
