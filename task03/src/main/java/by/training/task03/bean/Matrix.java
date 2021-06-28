package by.training.task03.bean;

import java.util.Arrays;

public class Matrix<T extends Number> {
    private T[][] matrix;

    public Matrix() {

    }

    public Matrix(T[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(Class<T> type, int n, int m){
        this.matrix = (T[][]) java.lang.reflect.Array.newInstance(type, n, m);
    }

    public int getVerticalSize() {
        return matrix.length;
    }

    public int getHorizontalSize() {
        return matrix[0].length;
    }

    public T getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) { // check i & j
            return matrix[i][j];
        } else {
            throw new MatrixException();
        }
    }

    public void setElement(int i, int j, T value) throws MatrixException {
        if (checkRange(i, j)) {
            matrix[i][j] = value;
        } else {
            throw new MatrixException();
        }
    }


    private boolean checkRange(int i, int j) {// check matrix range
        return i >= 0 && i <= matrix.length - 1 && j >= 0 && j <= matrix[0].length - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix<?> matrix1 = (Matrix<?>) o;
        return Arrays.deepEquals(matrix, matrix1.matrix);
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
        for (T[] row : matrix) {
            for (T value : row) {
                s.append(value).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }
}

