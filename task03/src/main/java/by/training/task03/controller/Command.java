package by.training.task03.controller;

import by.training.task03.bean.MatrixException;

import java.io.IOException;

public interface Command {
    public Object executeCommand() throws MatrixException, IOException;
}
