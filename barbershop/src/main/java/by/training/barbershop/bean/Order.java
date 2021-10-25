package by.training.barbershop.bean;

import java.sql.Timestamp;
import java.util.Objects;

public class Order extends Entity {
    private Timestamp dateTime;
    private Timestamp dateTimePlane;
    private User user;
    private Barber barber;
    private Haircut haircut;
    private OrderStatus status;
    public Order() {
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Timestamp getDateTimePlane() {
        return dateTimePlane;
    }

    public void setDateTimePlane(Timestamp dateTimePlane) {
        this.dateTimePlane = dateTimePlane;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public Haircut getHaircut() {
        return haircut;
    }

    public void setHaircut(Haircut haircut) {
        this.haircut = haircut;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(dateTime, order.dateTime) && Objects.equals(dateTimePlane, order.dateTimePlane) && Objects.equals(user, order.user) && Objects.equals(barber, order.barber) && Objects.equals(haircut, order.haircut) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateTime, dateTimePlane, user, barber, haircut, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "dateTime=" + dateTime +
                ", dateTimePlane=" + dateTimePlane +
                ", user=" + user +
                ", barber=" + barber +
                ", haircut=" + haircut +
                ", status=" + status +
                '}';
    }
}
