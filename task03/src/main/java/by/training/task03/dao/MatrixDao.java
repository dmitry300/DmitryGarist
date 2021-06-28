package by.training.task03.dao;

import by.training.task03.bean.Matrix;

public interface MatrixDao {
    Matrix<Double> saveMatrix(String fileName) ;
}
