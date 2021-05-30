package by.training.logic.branchingstatement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BranchingStatementTask05Test {

    BranchingStatementTask05 branchingStatementTask05 = new BranchingStatementTask05();

    @DataProvider(name = "dataForGetDefineFunction")
    public Object[][] createPositiveDataForGetDefineFunction() {
        return new Object[][]{
                {new double[]{-1}, 13},
                {new double[]{0}, 9},
                {new double[]{3}, 9},
                {new double[]{5}, 0.0076},
                {new double[]{5.5}, 0.0058},
                {new double[]{125.7}, 5.0349E-7},
        };
    }

    @Test(description = "Positive scenario of the DefineFunction", dataProvider = "dataForGetDefineFunction")
    public void testDefineFunction(double a[], double value) {
        double actual = branchingStatementTask05.defineFunction(a[0]);
        double expected = value;
        assertEquals(actual, expected, 0.0001);
    }
}