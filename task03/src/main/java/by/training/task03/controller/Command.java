package by.training.task03.controller;

import by.training.task03.bean.MatrixException;

import java.io.IOException;

public interface Command {
    public String executeCommand() throws MatrixException, IOException;
}
