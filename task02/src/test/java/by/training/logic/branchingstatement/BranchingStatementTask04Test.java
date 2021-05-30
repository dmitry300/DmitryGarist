package by.training.logic.branchingstatement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BranchingStatementTask04Test {

    BranchingStatementTask04 branchingStatementTask04 = new BranchingStatementTask04();

    @DataProvider(name = "dataForGetDefineNumber")
    public Object[][] createPositiveDataForGetDefineNumber() {
        return new Object[][]{
                {new double[]{0, 0, 0, 0}, 0},
                {new double[]{1, 2, 3, 2}, 2},
                {new double[]{1, 2, 3, 4}, 3},
                {new double[]{3, 3, 3, 4}, 1},
                {new double[]{5, 25, 13, 15}, 10},
                {new double[]{5.5, 2.5, 10.5, 2.5}, 2.5},
                {new double[]{5.5, 2.5, 4.5, 3.5}, 1},
        };
    }

    @Test(description = "Positive scenario of the DefineNumber", dataProvider = "dataForGetDefineNumber")
    public void testDefineNumber(double abcd[], double result) {
        double actual = branchingStatementTask04.defineNumber(abcd[0], abcd[1], abcd[2], abcd[3]);
        double expected = result;
        assertEquals(actual, expected, 0.0001);
    }
}