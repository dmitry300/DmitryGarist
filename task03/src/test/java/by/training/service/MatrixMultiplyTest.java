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
                {new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}),
                        new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}),
                        new Matrix(new double[][]{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}})},
                {new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}),
                        new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}),
                        new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}})},
                {new Matrix(new double[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}}),
                        new Matrix(new double[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}}),
                        new Matrix(new double[][]{{3, 3, 3}, {3, 3, 3}, {3, 3, 3}})}
        };
    }

    @Test(description = "Positive scenario of the matrix multiply", dataProvider = "dataForMatrixMultiply")
    public void testOperation(Matrix mtrx1, Matrix mtrx2, Matrix expectedMtrx) throws MatrixException {
        Matrix actual = matrixMultiply.operation(mtrx1, mtrx2);
        Matrix expected = expectedMtrx;
        assertEquals(actual, expected);
    }
}