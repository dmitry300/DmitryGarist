package by.training.task05.repository.specification.impl;

import by.training.task05.bean.Ball;
import by.training.task05.repository.specification.BallSortSpecification;

import java.util.Comparator;

public class SortBallById implements BallSortSpecification {

    @Override
    public Comparator<Ball> createComparator() {
        return Comparator.comparing(Ball::getId);
    }
}
