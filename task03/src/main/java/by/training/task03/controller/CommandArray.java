package by.training.task03.controller;

import by.training.task03.bean.Array;
import by.training.task03.bean.MatrixException;

import java.io.IOException;

public interface CommandArray {
    public Array<Double> executeCommand() throws MatrixException, IOException;
}
