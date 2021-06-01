package by.training.logic.branchingstatement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BranchingStatementTask02Test {
    BranchingStatementTask02 branchingStatementTask02 = new BranchingStatementTask02();

    @DataProvider(name = "dataForGetPowFunction")
    public Object[][] createPositiveDataForGetPowFunction() {
        return new Object[][]{
                {new double[]{0}, 0},
                {new double[]{-1}, 1},
                {new double[]{1}, 1},
                {new double[]{-5}, 625},
                {new double[]{5}, 25},
                {new double[]{10.5}, 110.25},
        };
    }

    @Test(description = "Positive scenario of the powFunction", dataProvider = "dataForGetPowFunction")
    public void testPowFunction(double[] a, double powResult) {
        double actual = branchingStatementTask02.powFunction(a[0]);
        double expected = powResult;
        assertEquals(actual, expected,0.0001);
    }
}