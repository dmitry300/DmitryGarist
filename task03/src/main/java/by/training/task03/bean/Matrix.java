package by.training.task03.bean;

import java.util.Arrays;

public class Matrix<T extends Number> {
    private T[][] a;

    public Matrix() {

    }

    public Matrix(T[][] a) {
        this.a = a;
    }

    public Matrix(Class<T> type, int n, int m) throws MatrixException {
        if (n < 1 || m < 1) {// check input
            throw new MatrixException();
        }
        a = (T[][]) java.lang.reflect.Array.newInstance(type, n, m);
    }

    public int getVerticalSize() {
        return a.length;
    }

    public int getHorizontalSize() {
        return a[0].length;
    }

    public T getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) { // check i & j
            return a[i][j];
        } else {
            throw new MatrixException();
        }
    }

    public void setElement(int i, int j, T value) throws MatrixException {
        if (checkRange(i, j)) {
            a[i][j] = value;
        } else {
            throw new MatrixException();
        }
    }


    private boolean checkRange(int i, int j) {// check matrix range
        if (i < 0 || i > a.length - 1 || j < 0 || j > a[0].length - 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        for (int i = 0; i < matrix1.getVerticalSize(); i++) {
            for (int j = 0; j < matrix1.getHorizontalSize(); j++) {
                try {
                    if (matrix1.getElement(i, j) != a[i][j]) {
                        return false;
                    }
                } catch (MatrixException e) {
                    e.printStackTrace();
                }
            }

        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(a);
    }

    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder("\nMatrix : " + a.length + "x"
                + a[0].length + "\n");
        for (T[] row : a) {
            for (T value : row) {
                s.append(value).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }
    //TODO сделать параметризацию для матрикс и array
}

