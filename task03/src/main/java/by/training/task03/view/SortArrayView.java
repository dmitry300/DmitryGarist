package by.training.task03.view;

import by.training.task03.bean.Array;
import by.training.task03.bean.MatrixException;
import by.training.task03.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class SortArrayView {
    private static final Logger logger = LogManager.getLogger(SortArrayView.class);

    public void printArraySort(String nameOFSort) throws MatrixException, IOException {
        Controller controller = new Controller();
        Array<Double> arrayResult = (Array<Double>)controller.execute(nameOFSort);
        logger.info(String.format("result: %s", arrayResult));
        System.out.println(nameOFSort + " : " + arrayResult);
    }

}
