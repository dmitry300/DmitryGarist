package by.training.task05.service;

import by.training.task05.bean.Ball;
import by.training.task05.dao.exception.DaoException;
import by.training.task05.service.exception.ServiceException;

import java.util.List;

public interface Loading {
    List<Ball> read(String fileName) throws DaoException, ServiceException;
}
