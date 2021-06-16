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
                {new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}),
                        new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}),
                        new Matrix(new double[][]{{2, 4, 6}, {8, 10, 12}, {14, 16, 18}})},
                {new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}),
                        new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}),
                        new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}})},
                {new Matrix(new double[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}}),
                        new Matrix(new double[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}}),
                        new Matrix(new double[][]{{-2, -2, -2}, {-2, -2, -2}, {-2, -2, -2}})}
        };
    }

    @Test(description = "Positive scenario of the matrix addition", dataProvider = "dataForMatrixAddition")
    public void testOperation(Matrix mtrx1, Matrix mtrx2, Matrix expectedMtrx) throws MatrixException {
        Matrix actual = matrixAddition.operation(mtrx1, mtrx2);
        Matrix expected = expectedMtrx;
        assertEquals(actual, expected);
    }
}