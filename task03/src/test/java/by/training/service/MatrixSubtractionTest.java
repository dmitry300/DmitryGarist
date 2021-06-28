package by.training.service;

import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;
import by.training.task03.service.impl.MatrixSubtraction;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MatrixSubtractionTest {

    MatrixSubtraction matrixSubtraction = new MatrixSubtraction();

    @DataProvider(name = "dataForMatrixSubtraction")
    public Object[][] createPositiveDataForMatrixSubtraction() {
        return new Object[][]{
                {new Matrix<>(new Double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}),
                        new Matrix<>(new Double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}),
                        new Matrix<>(new Double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}})},
                {new Matrix<>(new Double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}),
                        new Matrix<>(new Double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}),
                        new Matrix<>(new Double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}})},
                {new Matrix<>(new Double[][]{{-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}}),
                        new Matrix<>(new Double[][]{{-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}}),
                        new Matrix<>(new Double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}})}
        };
    }

    @Test(description = "Positive scenario of the matrix subtraction", dataProvider = "dataForMatrixSubtraction")
    public void testOperation(Matrix<Double> mtrx1, Matrix<Double> mtrx2, Matrix<Double> expectedMtrx) throws MatrixException {
        Matrix<Double> actual = matrixSubtraction.operation(mtrx1, mtrx2);
        assertEquals(actual, expectedMtrx);
    }
}