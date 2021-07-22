package by.training.task05.service.impl;

import by.training.task05.bean.Ball;
import by.training.task05.service.factory.ServiceFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DissectionBallTest {
    @DataProvider(name = "dataForBall")
    public Object[][] createPositiveDataForSquare() {
        Ball ball = new Ball(5);
        Ball.Point point = ball.new Point(5, 5, 2);
        ball.setPoint(point);
        return new Object[][]{
                {ball}
        };
    }

    @Test(description = "Positive scenario for calculating square of ball", dataProvider = "dataForBall")
    public void testFindVolumeRatio(Ball ball) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        double actual = serviceFactory.getDissection().findVolumeRatio(ball);
        double segment1 = 113.097;
        double segment2 = 410.501;
        double expected = segment1 / segment2;
        assertEquals(actual, expected, 0.001);
    }
}