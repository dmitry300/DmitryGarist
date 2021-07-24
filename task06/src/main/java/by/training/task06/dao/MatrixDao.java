package by.training.task06.dao;

import by.training.task06.bean.MatrixException;
import by.training.task06.bean.SquareMatrix;
import by.training.task06.dao.exception.DaoException;

import java.io.IOException;

public interface MatrixDao {
    SquareMatrix saveMatrix(String fileName) throws DaoException, MatrixException, IOException;
}
