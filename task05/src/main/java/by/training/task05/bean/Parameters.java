package by.training.task05.bean;

import java.util.Objects;

public class Parameters {
    private double volume;
    private double square;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameters that = (Parameters) o;
        return Double.compare(that.volume, volume) == 0 && Double.compare(that.square, square) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, square);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "volume=" + volume +
                ", square=" + square +
                '}';
    }
}
