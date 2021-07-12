package by.training.task03.controller.main;

import by.training.task03.bean.MatrixException;
import by.training.task03.view.MatrixOperationView;
import by.training.task03.view.SortArrayView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, MatrixException {
        SortArrayView sortArrayView = new SortArrayView();
        MatrixOperationView matrixOperationView = new MatrixOperationView();

        sortArrayView.printArraySort("bubble_sort_increasing");
        sortArrayView.printArraySort("insertion_sort_increasing");
        sortArrayView.printArraySort("selection_sort_increasing");
        sortArrayView.printArraySort("shaker_sort_increasing");
        sortArrayView.printArraySort("shell_sort_increasing");
        sortArrayView.printArraySort("merge_sort_increasing");
        sortArrayView.printArraySort("bubble_sort_decreasing");
        sortArrayView.printArraySort("insertion_sort_decreasing");
        sortArrayView.printArraySort("selection_sort_decreasing");
        sortArrayView.printArraySort("shaker_sort_decreasing");
        sortArrayView.printArraySort("shell_sort_decreasing");
        sortArrayView.printArraySort("merge_sort_decreasing");

        matrixOperationView.printMatrixResult("matrix_addition");
        matrixOperationView.printMatrixResult("matrix_subtraction");
        matrixOperationView.printMatrixResult("matrix_multiply");
    }
}
