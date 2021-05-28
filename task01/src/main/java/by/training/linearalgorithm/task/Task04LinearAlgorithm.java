package by.training.linearalgorithm.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 28. Составить программу перевода радианной меры угла в градусы, минуты и секунды.
 *
 * @author Dmitry Garist
 */

public class Task04LinearAlgorithm {

    private static final Logger logger = LogManager.getLogger(Task04LinearAlgorithm.class);


    public double[] getFunction(double angle) {
        double grad = Math.floor(angle * 180 / Math.PI);
        double minute = Math.floor((angle * 180 / Math.PI - grad) * 60);
        double sec = Math.floor((angle * 180 / Math.PI - grad) * 3600 - minute * 60);

        logger.info(grad + " гр " + minute + " мин " + sec + " с ");
        double[] array = {grad,minute,sec};
        return array;
    }

}
