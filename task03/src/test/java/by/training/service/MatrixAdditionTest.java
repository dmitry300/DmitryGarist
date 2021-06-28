package by.training.service;


import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;
import by.training.task03.service.impl.MatrixAddition;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MatrixAdditionTest {
    MatrixAddition matrixAddition = new MatrixAddition();


    @DataProvider(name = "dataForMatrixAddition")
    public Object[][] createPositiveDataForMatrixAddition() {
        return new Object[][]{
                {new Matrix<>(new Double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}),
                        new Matrix<>(new Double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}),
                        new Matrix<>(new Double[][]{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}})},
                {new Matrix<>(new Double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}),
                        new Matrix<>(new Double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}),
                        new Matrix<>(new Double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}})},
                {new Matrix<>(new Double[][]{{-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}}),
                        new Matrix<>(new Double[][]{{-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}, {-1.0, -1.0, -1.0}}),
                        new Matrix<>(new Double[][]{{-2.0, -2.0, -2.0}, {-2.0, -2.0, -2.0}, {-2.0, -2.0, -2.0}})}
        };
    }

    @Test(description = "Positive scenario of the matrix addition", dataProvider = "dataForMatrixAddition")
    public void testOperation(Matrix<Double> mtrx1, Matrix<Double> mtrx2, Matrix<Double> expectedMtrx) throws MatrixException {
        Matrix<Double> actual = matrixAddition.operation(mtrx1, mtrx2);
        assertEquals(actual, expectedMtrx);
    }
}