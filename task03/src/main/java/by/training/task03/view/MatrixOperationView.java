package by.training.task03.view;

import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;
import by.training.task03.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class MatrixOperationView {
    private static final Logger logger = LogManager.getLogger(MatrixOperationView.class);

    public void printMatrixResult(String nameOfOperation) throws MatrixException, IOException {
        Controller controller = new Controller();
        Matrix<Double> matrixResult = (Matrix<Double>) controller.execute(nameOfOperation);
        logger.info(String.format("result: %s", matrixResult));
        System.out.println(nameOfOperation + " : " + matrixResult);
    }

}
