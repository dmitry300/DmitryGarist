package by.training.task03.controller.impl;

import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;
import by.training.task03.controller.Command;
import by.training.task03.service.LoadingMatrix;
import by.training.task03.service.OperationWithMatrix;
import by.training.task03.service.factory.ServiceFactory;

import java.util.LinkedList;
import java.util.List;

public class MatrixSubtraction implements Command {

    @Override
    public Object executeCommand() throws MatrixException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LoadingMatrix loader = serviceFactory.getLoaderMatrix();
        List<Matrix<Double>> listMatrix = new LinkedList<>(loader.readTwoMatrix());
        Matrix<Double> matrix1 = listMatrix.get(0);
        Matrix<Double> matrix2 = listMatrix.get(1);
        OperationWithMatrix operationWithMatrix = serviceFactory.getSubtraction();
        return operationWithMatrix.operation(matrix1, matrix2);
    }
}
