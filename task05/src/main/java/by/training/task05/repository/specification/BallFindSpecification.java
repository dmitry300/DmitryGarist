package by.training.task05.repository.specification;

import by.training.task05.bean.Ball;

public interface BallFindSpecification extends BallSpecification {
    boolean isSpecified(Ball ball);
}
