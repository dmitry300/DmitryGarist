package by.training.task05.bean;

public class BallException extends Exception {
    public BallException() {
        super();
    }

    public BallException(Exception e) {
        super(e);
    }

    public BallException(String message) {
        super(message);
    }

    public BallException(String message, Exception e) {
        super(message, e);
    }
}
