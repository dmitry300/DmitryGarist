package by.training.task05.service.impl;

import by.training.task05.bean.Ball;
import by.training.task05.service.Volume;

public class VolumeBall implements Volume {
    @Override
    public double findVolume(Ball ball) {
        double radius = ball.getRadius();
        return 4 / 3.0 * Math.PI * Math.pow(radius, 3);
    }
}
