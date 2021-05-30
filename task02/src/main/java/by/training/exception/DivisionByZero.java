package by.training.exception;

public class DivisionByZero extends NumberFormatException {
    public DivisionByZero() {
        super("Деление на ноль запрещено!");
    }
}
