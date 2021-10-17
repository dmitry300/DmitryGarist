package by.training.barbershop.bean;

import java.sql.Timestamp;
import java.util.Objects;

public class Order extends Entity {
    private Timestamp dateTime;
   // private int userInfoId;
    private UserInfo userInfo;
  //  private int barberId;
    private Barber barber;
   // private int haircutId;
    private Haircut haircut;

    public Order() {
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(dateTime, order.dateTime) && Objects.equals(userInfo, order.userInfo) && Objects.equals(barber, order.barber) && Objects.equals(haircut, order.haircut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateTime, userInfo, barber, haircut);
    }

    @Override
    public String toString() {
        return "Order{" +
                "dateTime=" + dateTime +
                ", userInfo=" + userInfo +
                ", barber=" + barber +
                ", haircut=" + haircut +
                '}';
    }
}
