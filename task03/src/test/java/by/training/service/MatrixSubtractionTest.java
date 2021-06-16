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
                {new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}),
                        new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}),
                        new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}})},
                {new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}),
                        new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}),
                        new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}})},
                {new Matrix(new double[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}}),
                        new Matrix(new double[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}}),
                        new Matrix(new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}})}
        };
    }

    @Test(description = "Positive scenario of the matrix subtraction", dataProvider = "dataForMatrixSubtraction")
    public void testOperation(Matrix mtrx1, Matrix mtrx2, Matrix expectedMtrx) throws MatrixException {
        Matrix actual = matrixSubtraction.operation(mtrx1,mtrx2);
        Matrix expected = expectedMtrx;
        assertEquals(actual, expected);
    }
}