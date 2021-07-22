package by.training.task05.service.impl;

import by.training.task05.bean.Ball;
import by.training.task05.service.factory.ServiceFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SquareBallTest {

    @DataProvider(name = "dataForBall")
    public Object[][] createPositiveDataForSquare() {
        Ball ball = new Ball(1);
        return new Object[][]{
                {ball}
        };
    }

    @Test(description = "Positive scenario for calculating square of ball", dataProvider = "dataForBall")
    public void testFindSquare(Ball ball) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        double actual = serviceFactory.getSquare().findSquare(ball);
        double expected = 12.566;
        assertEquals(actual, expected, 0.001);
    }
}