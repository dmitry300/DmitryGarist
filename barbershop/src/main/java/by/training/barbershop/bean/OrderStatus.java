package by.training.barbershop.bean;

public enum OrderStatus {
    APPROVED("approved"), REJECTED("rejected"), WAITING("waiting");
    private final String name;

    OrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return ordinal();
    }

    public static OrderStatus getById(Integer id) {
        return OrderStatus.values()[id];
    }
}
