package by.training.task03.controller.impl;

import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;
import by.training.task03.controller.CommandMatrix;
import by.training.task03.service.OperationWithMatrixLoad;
import by.training.task03.service.ServiceFactory;

public class MatrixSubtraction implements CommandMatrix {

    @Override
    public Matrix<Double> executeCommand() throws MatrixException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        OperationWithMatrixLoad operationWithMatrixLoad = serviceFactory.getSubtractionLoad();
        return operationWithMatrixLoad.operation();
    }
}
