package by.training.task05.controller.impl;

import by.training.task05.bean.Ball;
import by.training.task05.controller.Command;
import by.training.task05.dao.exception.DaoException;
import by.training.task05.repository.Repository;
import by.training.task05.repository.impl.BallRepository;
import by.training.task05.repository.specification.BallFindSpecification;
import by.training.task05.repository.specification.impl.FindBallById;
import by.training.task05.service.Loading;
import by.training.task05.service.Square;
import by.training.task05.service.exception.ServiceException;
import by.training.task05.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SquareBall implements Command {
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static final Logger logger = LogManager.getLogger(SquareBall.class);

    @Override
    public Object executeCommand(String idObject, String fileName) {
        Loading loading = serviceFactory.getLoading();
        try {
            List<Ball> list = loading.read(fileName);
            Repository repository = new BallRepository();
            repository.addAll(list);
            BallFindSpecification ballFindSpecification = new FindBallById(Long.parseLong(idObject));
            List<Ball> resultListBall = repository.query(ballFindSpecification);
            Ball resultBall = resultListBall.get(0);
            Square square = serviceFactory.getSquare();
            return square.findSquare(resultBall);
        } catch (ServiceException | DaoException e) {
            logger.error("Error reading data from file! " + e);
        }
        return null;
    }
}
