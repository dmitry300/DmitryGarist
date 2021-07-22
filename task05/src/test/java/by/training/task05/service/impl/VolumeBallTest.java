package by.training.task05.service.impl;

import by.training.task05.bean.Ball;
import by.training.task05.service.factory.ServiceFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VolumeBallTest {
    @DataProvider(name = "dataForBall")
    public Object[][] createPositiveDataForSquare() {
        Ball ball = new Ball(1);
        return new Object[][]{
                {ball}
        };
    }

    @Test(description = "Positive scenario for calculating square of ball", dataProvider = "dataForBall")
    public void testFindVolume(Ball ball) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        double actual = serviceFactory.getVolume().findVolume(ball);
        double expected = 4.189;
        assertEquals(actual, expected, 0.001);
    }
}