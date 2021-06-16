package by.training.task03.service.impl;

import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;
import by.training.task03.dao.DAOFactory;
import by.training.task03.dao.MatrixDao;
import by.training.task03.service.OperationWithMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixSubtraction implements OperationWithMatrix {
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final Logger logger = LogManager.getLogger(MatrixSubtraction.class);

    /**
     * @param matrix1 - first matrix
     * @param matrix2 - second matrix
     * @return matrix result
     */
    @Override
    public Matrix<Number> operation(Matrix<Number> matrix1, Matrix<Number> matrix2) {
        if (matrix1 == null) {
            MatrixDao matrixDao1 = daoFactory.getFileMatrix1Dao();
            matrix1 = matrixDao1.saveMatrix();
        }
        if (matrix2 == null) {
            MatrixDao matrixDao2 = daoFactory.getFileMatrix2Dao();
            matrix2 = matrixDao2.saveMatrix();
        }

        int v = matrix1.getVerticalSize();
        int h = matrix2.getHorizontalSize();
        Matrix result = null;
        try {
            result = new Matrix<>(Number.class, v, h);
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    double value = 0;
                    value += matrix1.getElement(i, j).doubleValue() - matrix2.getElement(i, j).doubleValue();
                    result.setElement(i, j, value);
                }
            }
        } catch (MatrixException e) {
            logger.error(String.format("Error creating matrix %s", e));
        }
        return result;
    }
}
