package by.training.task05.repository;

import by.training.task05.bean.Ball;
import by.training.task05.repository.specification.BallSpecification;

import java.util.Collection;
import java.util.List;

public interface Repository {
    void addElement(Ball ball);

    void addAll(Collection<Ball> list);

//    void updateElement(Ball ball, Registrar registrar);
//
//    void updateAll(Collection<Ball> list, Registrar registrar);

    void removeElement(Ball ball);

    void removeAll(Collection<Ball> list);

    List<Ball> query(BallSpecification specification);
}
