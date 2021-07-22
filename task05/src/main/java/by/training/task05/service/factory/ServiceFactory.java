package by.training.task05.service.factory;

import by.training.task05.service.*;
import by.training.task05.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final Dissection dissection = new DissectionBall();
    private final Square square = new SquareBall();
    private final Touching touching = new TouchingBall();
    private final Volume volume = new VolumeBall();
    private final Loading loading = new Loader();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public Loading getLoading() {
        return loading;
    }

    public Dissection getDissection() {
        return dissection;
    }

    public Square getSquare() {
        return square;
    }

    public Touching getTouching() {
        return touching;
    }

    public Volume getVolume() {
        return volume;
    }
}
