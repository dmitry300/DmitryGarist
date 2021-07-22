package by.training.task05.dao;

import by.training.task05.bean.Ball;
import by.training.task05.dao.exception.DaoException;

import java.util.List;

public interface BallDao {
    List<Ball> saveBall(String fileName) throws DaoException;
}
