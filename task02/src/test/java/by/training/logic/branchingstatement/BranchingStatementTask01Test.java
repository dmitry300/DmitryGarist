package by.training.logic.branchingstatement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BranchingStatementTask01Test {
    BranchingStatementTask01 branchingStatementTask01 = new BranchingStatementTask01();

    @DataProvider(name = "dataForGetEqualsTwoNumber")
    public Object[][] createPositiveDataForGetMultiply() {
        return new Object[][]{
                {new double[]{0, 0}, true},
                {new double[]{-1, -1}, true},
                {new double[]{1, 1}, true},
                {new double[]{1000, 1000}, true},
                {new double[]{100.5, 100.5}, true}
        };
    }

    @Test(description = "Positive scenario of the equalsTwoNumber", dataProvider = "dataForGetEqualsTwoNumber")
    public void testEqualsTwoNumber(double[] ab, boolean isEqual) {
        boolean actual = branchingStatementTask01.equalsTwoNumber(ab[0], ab[1]);
        boolean expected = isEqual;
        assertEquals(actual, expected);
    }
}