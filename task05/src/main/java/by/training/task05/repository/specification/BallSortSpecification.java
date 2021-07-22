package by.training.task05.repository.specification;

import by.training.task05.bean.Ball;

import java.util.Comparator;

public interface BallSortSpecification extends BallSpecification{
    Comparator<Ball> createComparator();
}
