package by.training.task03.controller;

import by.training.task03.bean.MatrixException;
import by.training.task03.view.MatrixOperationView;
import by.training.task03.view.SortArrayView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, MatrixException {
        SortArrayView sortArrayView = new SortArrayView();
        MatrixOperationView matrixOperationView = new MatrixOperationView();

        sortArrayView.printArraySort("Array bubble_sort_increasing");
        sortArrayView.printArraySort("Array insertion_sort_increasing");
        //sortArrayView.printArraySort("insertion_hash_sort_increasing");
        sortArrayView.printArraySort("Array selection_sort_increasing");
        sortArrayView.printArraySort("Array shaker_sort_increasing");
        sortArrayView.printArraySort("Array shell_sort_increasing");
        sortArrayView.printArraySort("Array merge_sort_increasing");
        sortArrayView.printArraySort("Array bubble_sort_decreasing");
        sortArrayView.printArraySort("Array insertion_sort_decreasing");
       // sortArrayView.printArraySort("insertion_hash_sort_decreasing");
        sortArrayView.printArraySort("Array selection_sort_decreasing");
        sortArrayView.printArraySort("Array shaker_sort_decreasing");
        sortArrayView.printArraySort("Array shell_sort_decreasing");
        sortArrayView.printArraySort("Array merge_sort_decreasing");

        matrixOperationView.printMatrixResult("Matrix matrix_addition");
        matrixOperationView.printMatrixResult("Matrix matrix_subtraction");
        matrixOperationView.printMatrixResult("Matrix matrix_multiply");
    }
}
