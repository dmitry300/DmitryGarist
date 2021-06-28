package by.training.task03.view;

import by.training.task03.bean.MatrixException;
import by.training.task03.controller.Controller;

import java.io.IOException;

public class SortArrayView {
    public void printArraySort(String nameOFSort) throws MatrixException, IOException {
        Controller controller = new Controller();
        System.out.println(nameOFSort + " : " + controller.executeArray(nameOFSort));
    }

}
