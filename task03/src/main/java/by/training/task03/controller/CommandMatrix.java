package by.training.task03.controller;

import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;

import java.io.IOException;

public interface CommandMatrix {
    public Matrix<Double> executeCommand() throws MatrixException, IOException;
}
