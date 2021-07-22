package by.training.task05.observer;

import by.training.task05.bean.Ball;

import java.util.EventObject;

public class BallEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public BallEvent(Object source) {
        super(source);
    }

    @Override
    public Ball getSource() {
        return (Ball) super.getSource();
    }

}
