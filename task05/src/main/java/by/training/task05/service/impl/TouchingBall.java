package by.training.task05.service.impl;

import by.training.task05.bean.Ball;
import by.training.task05.service.Touching;

public class TouchingBall implements Touching {
    @Override
    public boolean isTouching(Ball ball) {
        // Ball.Point point = ball.new Point();
//        Ball.Point point = ball.getPoint();
        double radius = ball.getRadius();
        double x = ball.getPoint().getXCoordinate();
        double y = ball.getPoint().getYCoordinate();
        double z = ball.getPoint().getZCoordinate();
        //шар может касаться 3ех плоскостей XY ZY XY, если шар касается например
        //XY, тогда радиус должен равняться длине от этой общей точки(x1,y1,0) до координаты Z
        //где (x1,y1,) совпадают с точками шара
        return radius == x || radius == y || radius == z;
    }
}
