package by.training.task03.controller.impl;

import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;
import by.training.task03.controller.Command;
import by.training.task03.service.OperationWithMatrix;
import by.training.task03.service.ServiceFactory;

public class MatrixAddition implements Command {
    @Override
    public String executeCommand() throws MatrixException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        OperationWithMatrix operationWithMatrix = serviceFactory.getAddition();
        Matrix<Number> matrix1 = null;
        Matrix<Number> matrix2 = null;
        return operationWithMatrix.operation(matrix1, matrix2).toString();
    }
}
