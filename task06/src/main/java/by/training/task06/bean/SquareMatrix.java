package by.training.task06.bean;

import java.util.Arrays;

public class SquareMatrix {
    private double[][] matrix;

    public SquareMatrix() {

    }

    public SquareMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public SquareMatrix(int n, int m) throws MatrixException {
        if (checkSquare(n, m)) {
            matrix = new double[n][m];
        } else {
            throw new MatrixException();
        }
    }

    public int getSize() {
        return matrix[0].length;
    }

    public double getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) { // check i & j
            return matrix[i][j];
        } else {
            throw new MatrixException();
        }
    }

    public void setElement(int i, int j, double value) throws MatrixException {
        if (checkRange(i, j)) {
            matrix[i][j] = value;
        } else {
            throw new MatrixException();
        }
    }


    private boolean checkRange(int i, int j) {// check matrix range
        return i >= 0 && i <= matrix.length - 1 && j >= 0 && j <= matrix[0].length - 1;
    }

    private boolean checkSquare(int n, int m) {// check matrix range
        return n == m;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareMatrix that = (SquareMatrix) o;
        return Arrays.deepEquals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder("\nMatrix : " + matrix.length + "x"
                + matrix[0].length + "\n");
        for (double[] row : matrix) {
            for (double value : row) {
                s.append(value).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }
}
