package by.training.barbershop.bean;

public enum UserRole {
    ADMIN("administrator"), CLIENT("client"), GUEST("guest");
    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return ordinal();
    }

    public static UserRole getById(Integer id) {
        return UserRole.values()[id];
    }
}
