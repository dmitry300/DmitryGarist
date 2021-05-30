package by.training.logic.branchingstatement;

import by.training.exception.DivisionByZero;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BranchingStatementTask03Test {
    BranchingStatementTask03 branchingStatementTask03 = new BranchingStatementTask03();

    @DataProvider(name = "dataForGetDivider")
    public Object[][] createPositiveDataForGetDivider() {
        return new Object[][]{
                {new int[]{5, 10, 15, 5}, new int[]{5, 10, 15}},
                {new int[]{0, 0, 0, 1}, new int[]{0, 0, 0}},
                {new int[]{1, 1, 1, 2}, new int[]{0, 0, 0}},
                {new int[]{20, 30, 40, 8}, new int[]{40, 0, 0}},
                {new int[]{20, 30, 40, 6}, new int[]{30, 0, 0}},
                {new int[]{20, 30, 40, 4}, new int[]{20, 40, 0}}
        };
    }

    @Test(description = "Positive scenario of the Divider ", dataProvider = "dataForGetDivider")
    public void testDivider(int abcd[], int result[]) {
        int actual[] = branchingStatementTask03.divider(abcd[0], abcd[1], abcd[2], abcd[3]);
        int expected[] = result;
        assertEquals(actual, expected);
    }

    @Test(description = "Negative first scenario of the Calculate",
            enabled = true, expectedExceptions = DivisionByZero.class,
            expectedExceptionsMessageRegExp = "Деление на ноль запрещено!")
    public void testNegative1Calculate() throws DivisionByZero {
        branchingStatementTask03.divider(1, 2, 3, 0);
    }
}