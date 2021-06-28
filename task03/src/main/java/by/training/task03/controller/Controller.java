package by.training.task03.controller;

import by.training.task03.bean.Array;
import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;

import java.io.IOException;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public Array<Double> executeArray(String request) throws MatrixException, IOException {
        String commandName;
        String repositoryName;
        String[] params;

        params = request.split("\\s+");
        repositoryName = params[0].toUpperCase();
        commandName = params[1];
        if (repositoryName.equals("ARRAY")) {
            return provider.getCommand1(commandName).executeCommand();
        }
        return null;
    }

    public Matrix<Double> executeMatrix(String request) throws MatrixException, IOException {
        String commandName;
        String repositoryName;
        String[] params;

        params = request.split("\\s+");
        repositoryName = params[0].toUpperCase();
        commandName = params[1];
        if (repositoryName.equals("MATRIX")) {
            return provider.getCommand2(commandName).executeCommand();
        }
        return null;
    }
}
