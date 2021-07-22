package by.training.task05.bean;

import by.training.task05.observer.BallEvent;
import by.training.task05.observer.Observable;
import by.training.task05.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ball extends Figure implements Observable {
    private double radius;
    private Point point;
    private List<Observer> observers = new ArrayList();

    public Ball() {

    }

    public Ball(double radius) {
        this.radius = radius;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        BallEvent event = new BallEvent(this);
        if (!observers.isEmpty()) {
            for (Observer observer : observers) {
                observer.update(event);
            }
        }

    }

    public class Point {
        private double xCoordinate;
        private double yCoordinate;
        private double zCoordinate;

        public Point() {

        }

        public Point(double xCoordinate, double yCoordinate, double zCoordinate) {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
            this.zCoordinate = zCoordinate;
        }

        public double getXCoordinate() {
            return xCoordinate;
        }

        public void setXCoordinate(double xCoordinate) {
            this.xCoordinate = xCoordinate;
        }

        public double getYCoordinate() {
            return yCoordinate;
        }

        public void setYCoordinate(double yCoordinate) {
            this.yCoordinate = yCoordinate;
        }

        public double getZCoordinate() {
            return zCoordinate;
        }

        public void setZCoordinate(double zCoordinate) {
            this.zCoordinate = zCoordinate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.xCoordinate, xCoordinate) == 0 && Double.compare(point.yCoordinate, yCoordinate) == 0 && Double.compare(point.zCoordinate, zCoordinate) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), xCoordinate, yCoordinate, zCoordinate);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "xCoordinate=" + xCoordinate +
                    ", yCoordinate=" + yCoordinate +
                    ", zCoordinate=" + zCoordinate +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "radius=" + radius +
                '}';
    }
}
