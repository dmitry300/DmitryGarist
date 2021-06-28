package by.training.service;

import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;
import by.training.task03.service.impl.MatrixMultiply;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MatrixMultiplyTest {

    MatrixMultiply matrixMultiply = new MatrixMultiply();


    @DataProvider(name = "dataForMatrixMultiply")
    public Object[][] createPositiveDataForMatrixMultiply() {
        return new Object[][]{
                {new Matrix<>(new Double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}),
                        new Matrix<>(new Double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}),
                        new Matrix<>(new Double[][]{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}})},
                {new Matrix<>(new Double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}),
                        new Matrix<>(new Double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}),
                        new Matrix<>(new Double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}})},
                {new Matrix<>(new Double[][]{{-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}}),
                        new Matrix<>(new Double[][]{{-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}}),
                        new Matrix<>(new Double[][]{{3.0, 3.0, 3.0}, {3.0, 3.0, 3.0}, {3.0, 3.0, 3.0}})}
        };
    }

    @Test(description = "Positive scenario of the matrix multiply", dataProvider = "dataForMatrixMultiply")
    public void testOperation(Matrix<Double> mtrx1, Matrix<Double> mtrx2, Matrix<Double> expectedMtrx) throws MatrixException {
        Matrix<Double> actual = matrixMultiply.operation(mtrx1, mtrx2);
        assertEquals(actual, expectedMtrx);
    }
}