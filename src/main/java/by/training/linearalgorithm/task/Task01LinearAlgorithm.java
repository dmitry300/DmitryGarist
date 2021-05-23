package by.training.linearalgorithm.task;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *  (4) Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
 * @author Dmitry Garist
 */

public class Task01LinearAlgorithm {

    private static final Logger logger = LogManager.getLogger(Task01LinearAlgorithm.class);

    /**
     * @param a - вх.параметр
     * @param b - вх.параметр
     * @param c - вх.параметр
     * @return z - возращаемое наше значение
     */
    public double expression(double a, double b, double c) {
        logger.info(String.format("Expression is called a = %s, b = %s, c = %s", a, b, c));
        return ((a - 3) * b / 2) + c;
    }

    /**
     * @param a - слагаемое
     * @param b - слагаемое
     * @return сумму двух чисел
     */
    public double getSum(double a, double b) {
        logger.info(String.format("getSum is called a = %s, b = %s", a, b));
        return a + b;
    }

    /**
     * @param a - вычитаемое
     * @param b - вычитающее
     * @return - разность двух чисел
     */
    public double getDifference(double a, double b) {
        logger.info(String.format("getDifference is called a = %s, b = %s", a, b));
        return a - b;
    }

    /**
     * @param a - умножаемое
     * @param b - умножающее
     * @return умножение двух чисел
     */
    public double getMultiply(double a, double b) {
        logger.info(String.format("getMultiply is called a = %s, b = %s", a, b));
        return a * b;
    }
}
