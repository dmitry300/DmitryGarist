package by.training.linearalgorithm.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * (12) Вычислить расстояние между двумя точками с данными координатами (х1, у1) и (x2, у2).").
 *
 * @author Dmitry Garist
 */

public class Task02LinearAlgorithm {

    private static final Logger logger = LogManager.getLogger(Task02LinearAlgorithm.class);

    /**
     * @param x1 1ая координата
     * @param x2 2ая координата
     * @param y1 3яя координата
     * @param y2 4ая координата
     * @return расстояние между двумя точками
     */
    public double function(double x1, double x2, double y1, double y2) {
        double result;
        result = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        logger.info(String.format("getFunction (х1, у1)и (x2, у2), где x1 = %s,x2 = %s,y1 = %s,y2 = %s, result = %s ", x1, x2, y1, y2, result));
        return result;
    }

    /**
     * @param x2 - вычитаемое
     * @param x1 - вычитающее
     * @return - разность двух чисел
     */
    public double differenceX(double x1, double x2) {
        logger.info(String.format("getDifference is called x2 = %s, x1 = %s", x2, x1));
        return x2 - x1;
    }

    /**
     * @param y2 - вычитаемое
     * @param y1 - вычитающее
     * @return - разность двух чисел
     */
    public double differenceY(double y1, double y2) {
        logger.info(String.format("getDifference is called x2 = %s, x1 = %s", y2, y1));
        return y2 - y1;
    }

    /**
     * @param x2 - вычитаемое
     * @param x1 - вычитающее
     * @return квадрат разности
     */
    public double powX(double x1, double x2) {
        logger.info(String.format("getPow is called x1 = %s, x2 = %s", x1, x2));
        return Math.pow((x2 - x1), 2);
    }

    /**
     * @param y2 - вычитаемое
     * @param y1 - вычитающее
     * @return квадрат разности
     */
    public double powY(double y1, double y2) {
        logger.info(String.format("getPow is called x1 = %s, x2 = %s", y1, y2));
        return Math.pow((y2 - y1), 2);
    }
}
