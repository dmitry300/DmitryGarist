package by.training.task05.service.impl;

import by.training.task05.bean.Ball;
import by.training.task05.service.factory.ServiceFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TouchingBallTest {
    @DataProvider(name = "dataForBall")
    public Object[][] createPositiveDataForSquare() {
        Ball ball = new Ball(5);
        Ball.Point point = ball.new Point(4,5,6);
        ball.setPoint(point);
        return new Object[][]{
                {ball}
        };
    }

    @Test(description = "Positive scenario for calculating square of ball", dataProvider = "dataForBall")
    public void testIsTouching(Ball ball) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        boolean actual = serviceFactory.getTouching().isTouching(ball);
        assertTrue(actual);
    }
}