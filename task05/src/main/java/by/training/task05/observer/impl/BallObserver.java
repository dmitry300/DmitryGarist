package by.training.task05.observer.impl;

import by.training.task05.bean.Ball;
import by.training.task05.bean.BallException;
import by.training.task05.bean.Parameters;
import by.training.task05.bean.Warehouse;
import by.training.task05.observer.BallEvent;
import by.training.task05.observer.Observer;
import by.training.task05.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallObserver implements Observer {
    private final Logger logger = LogManager.getLogger(BallObserver.class);
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public void update(BallEvent event) {
        Ball ball = event.getSource();
        long id = ball.getId();
        Warehouse warehouse = Warehouse.getInstance();
        try {
            Parameters parameters = warehouse.get(id);
            double volume = serviceFactory.getVolume().findVolume(ball);
            double square = serviceFactory.getSquare().findSquare(ball);
            parameters.setVolume(volume);
            parameters.setSquare(square);
            logger.info(String.format("Volume {%s} was changed", volume));
        } catch (BallException e) {
            logger.error(String.format("exception {%s} in updateVolume method", e));
        }
    }
}