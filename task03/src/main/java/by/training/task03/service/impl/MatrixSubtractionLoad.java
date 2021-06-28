package by.training.task03.service.impl;

import by.training.task03.bean.Matrix;
import by.training.task03.dao.DAOFactory;
import by.training.task03.dao.MatrixDao;
import by.training.task03.service.OperationWithMatrixLoad;

public class MatrixSubtractionLoad implements OperationWithMatrixLoad {
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private final MatrixDao matrixDao = daoFactory.getFileMatrixDao();
    private final Matrix<Double> matrix1 = matrixDao.saveMatrix("C:/Users/KaMo User/IdeaProjects/demomatrix/src/data/dataForMatrix1.txt");
    private final Matrix<Double> matrix2 = matrixDao.saveMatrix("C:/Users/KaMo User/IdeaProjects/demomatrix/src/data/dataForMatrix2.txt");

    @Override
    public Matrix<Double> operation() {
        return new MatrixSubtraction().operation(matrix1, matrix2);
    }
}
