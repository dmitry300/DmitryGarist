package by.training.task03.view;

import by.training.task03.bean.MatrixException;
import by.training.task03.controller.Controller;

import java.io.IOException;

public class MatrixOperationView {
    public void printMatrixResult(String nameOfOperation) throws MatrixException, IOException {
        Controller controller = new Controller();
        System.out.println(nameOfOperation + " : " + controller.executeMatrix(nameOfOperation));
    }

}
