package by.training.xml.bean;

import java.util.Objects;

public class PackageMedicine {
    private String type;
    private String price;
    private int amount;

    public PackageMedicine(){

    }
    public PackageMedicine(String type, String price, int amount) {
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageMedicine that = (PackageMedicine) o;
        return amount == that.amount && Objects.equals(type, that.type) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, amount);
    }

    @Override
    public String toString() {
        return "PackageMedicine{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
