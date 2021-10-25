package by.training.barbershop.bean;

public enum UserStatus {
    BLOCKED("blocked"), PERMITTED("permitted");
    private final String name;

    UserStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return ordinal();
    }

    public static UserStatus getById(Integer id) {
        return UserStatus.values()[id];
    }
}
