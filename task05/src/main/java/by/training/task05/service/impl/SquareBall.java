package by.training.task05.service.impl;

import by.training.task05.bean.Ball;
import by.training.task05.service.Square;

public class SquareBall implements Square {
    @Override
    public double findSquare(Ball ball) {
        double radius = ball.getRadius();
        return 4 * Math.PI * radius * radius;
    }
}
