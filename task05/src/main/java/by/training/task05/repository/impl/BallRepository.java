package by.training.task05.repository.impl;

import by.training.task05.bean.Ball;
import by.training.task05.repository.Repository;
import by.training.task05.repository.specification.BallFindSpecification;
import by.training.task05.repository.specification.BallSortSpecification;
import by.training.task05.repository.specification.BallSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BallRepository implements Repository {
    private static final Logger logger = LogManager.getLogger(BallRepository.class);
    private static final BallRepository instance = new BallRepository();
    private List<Ball> listBall;

    public BallRepository() {
        listBall = new ArrayList<>();
    }

    public static BallRepository getInstance() {
        return instance;
    }

    @Override
    public void addElement(Ball ball) {
        listBall.add(ball);
        logger.info("New ball in repository:" + ball);
    }

    @Override
    public void addAll(Collection<Ball> list) {
        listBall.addAll(list);
        logger.info("New balls in repository:" + list);
    }

    @Override
    public void removeElement(Ball ball) {
        listBall.remove(ball);
        logger.info("Removed ball in repository:" + ball);
    }

    @Override
    public void removeAll(Collection<Ball> list) {
        listBall.removeAll(list);
        logger.info("Removed balls in repository:" + list);
    }

    @Override
    public List<Ball> query(BallSpecification specification) {
        List<Ball> listReturn = null;
        if (specification instanceof BallFindSpecification) {
            listReturn = listBall.stream().filter(((BallFindSpecification) specification)::isSpecified).collect(Collectors.toList());
        }
        if (specification instanceof BallSortSpecification) {
            listBall.sort(((BallSortSpecification) specification).createComparator());
            listReturn = new ArrayList<>(listBall);
        }
        return listReturn;
    }
}
