package by.training.information_handling.dao;

import by.training.information_handling.dao.exception.DaoException;

public interface TextDao {
    String saveText(String fileName) throws DaoException, DaoException;
}
