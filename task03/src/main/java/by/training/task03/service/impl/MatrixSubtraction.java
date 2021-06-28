package by.training.task03.service.impl;

import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;
import by.training.task03.service.OperationWithMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixSubtraction implements OperationWithMatrix {
    private static final Logger logger = LogManager.getLogger(MatrixSubtraction.class);

    /**
     * @param matrix1 - first matrix
     * @param matrix2 - second matrix
     * @return matrix result
     */
    @Override
    public Matrix<Double> operation(Matrix<Double> matrix1, Matrix<Double> matrix2) {
        int v = matrix1.getVerticalSize();
        int h = matrix2.getHorizontalSize();
        Matrix<Double> result = null;
        try {
            result = new Matrix<>(Double.class, v, h);
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    double value = 0;
                    value += matrix1.getElement(i, j) - matrix2.getElement(i, j);
                    result.setElement(i, j, value);
                }
            }
        } catch (MatrixException e) {
            logger.error(String.format("Error creating matrix %s", e));
        }
        return result;
    }
}
