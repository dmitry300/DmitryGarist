package by.training.logic.loop;

import by.training.exception.DivisionByZero;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoopTask04Test {
    LoopTask04 loopTask04 = new LoopTask04();

    @DataProvider(name = "dataForGetCalculation")
    public Object[][] createPositiveDataForGetCalculation() {
        return new Object[][]{
                {new double[]{1, 2}, '*', 2},
                {new double[]{1, 2}, '/', 0.5},
                {new double[]{1, 2}, '+', 3},
                {new double[]{1, 2}, '-', -1},
        };
    }

    @Test(description = "Positive scenario of the Calculate", dataProvider = "dataForGetCalculation")
    public void testCalculate(double ab[], char sign, double value) throws DivisionByZero {
        double actual = loopTask04.calculate(ab[0], ab[1], sign);
        double expected = value;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(description = "Negative first scenario of the Calculate",
            enabled = true, expectedExceptions = DivisionByZero.class,
            expectedExceptionsMessageRegExp = "Деление на ноль запрещено!")
    public void testNegative1Calculate() throws DivisionByZero {
        loopTask04.calculate(1, 0, '/');
    }

    @Test(description = "Negative second scenario of the Calculate",
            enabled = true, expectedExceptions = IllegalStateException.class)
    public void testNegative2Calculate() throws IllegalStateException {
        loopTask04.calculate(1, 1, 'a');
    }

}