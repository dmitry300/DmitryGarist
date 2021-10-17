package by.training.barbershop.bean;

import java.sql.Time;
import java.util.Objects;

public class Haircut extends Entity {
    private String name;
    private Time time;
    private double price;

    public Haircut() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Haircut haircut = (Haircut) o;
        return Double.compare(haircut.price, price) == 0 && Objects.equals(name, haircut.name) && Objects.equals(time, haircut.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, time, price);
    }

    @Override
    public String toString() {
        return "Haircut{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", price=" + price +
                '}';
    }
}
