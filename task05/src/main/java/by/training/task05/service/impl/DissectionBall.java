package by.training.task05.service.impl;

import by.training.task05.bean.Ball;
import by.training.task05.service.Dissection;

public class DissectionBall implements Dissection {

    @Override
    public double findVolumeRatio(Ball ball) {
        double radius = ball.getRadius();
        double x = ball.getPoint().getXCoordinate();
        double y = ball.getPoint().getYCoordinate();
        double z = ball.getPoint().getZCoordinate();
        //double[] array = new double[]{x, y, z};
//        for (int i = 0; i < array.length; i++) {//координаты делаем положительными, если они таковыми не являются
//            if (array[i] < 0) {
//                array[i] = Math.abs(array[i]);
//            }
//        }
        //объем сегмента шара = pi*h^2(R - h/3),где h = R-x\y\z
        double volumeFirstSegmentZ = Math.PI * Math.pow(radius - z, 2) * (radius - (radius - z) / 3);
        double volumeFirstSegmentX = Math.PI * Math.pow(radius - x, 2) * (radius - (radius - x) / 3);
        double volumeFirstSegmentY = Math.PI * Math.pow(radius - y, 2) * (radius - (radius - y) / 3);
        double volumeSecondSegmentZ = Math.PI * Math.pow(radius + z, 2) * (radius - (radius + z) / 3);
        double volumeSecondSegmentX = Math.PI * Math.pow(radius + x, 2) * (radius - (radius + x) / 3);
        double volumeSecondSegmentY = Math.PI * Math.pow(radius + y, 2) * (radius - (radius + y) / 3);
        if ((z < radius && x < radius && y < radius) || (z < radius && x < radius) ||
                (z < radius && y < radius) || (x < radius && y < radius)) { //пересекает несколько областей
            return -1;
        } else if (z < radius) { //пересекает XY
            return volumeFirstSegmentZ / volumeSecondSegmentZ;
        } else if (x < radius) {// пересекает ZY
            return volumeFirstSegmentX / volumeSecondSegmentX;
        } else if (y < radius) { //пересекает ZX
            return volumeFirstSegmentY / volumeSecondSegmentY;
        } else {
            return -1; // не пересекает ни одну плоскость
        }
    }
}
