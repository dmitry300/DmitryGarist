package by.training.task05.repository.specification.impl;

import by.training.task05.bean.Ball;
import by.training.task05.repository.specification.BallFindSpecification;

public class FindBallById implements BallFindSpecification {

    private final long searchId;

    public FindBallById(long searchId) {
        this.searchId = searchId;
    }

    @Override
    public boolean isSpecified(Ball ball) {
        return searchId == ball.getId();
    }
}
