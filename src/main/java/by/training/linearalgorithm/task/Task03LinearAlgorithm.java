package by.training.linearalgorithm.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 20. Известна длина окружности. Найти площадь круга, ограниченного этой окружностью.
 *
 * @author Dmitry Garist
 */

public class Task03LinearAlgorithm {

    private static final Logger logger = LogManager.getLogger(Task03LinearAlgorithm.class);

    /**
     * @param l длина окружности
     * @return расстояние между двумя точками
     */
    public double getFunction(double l) {
        if (l <= 0) {
            throw new IllegalArgumentException("It can't be: length of circle is < = 0!");
        }
        logger.info(String.format("getFunction: l = %s", l));
        return l * l / (4 * Math.PI);
    }

    /**
     * @param a - умножаемое
     * @param b - умножающее
     * @return умножение двух чисел
     */
    public double getMultiply(double a, double b) {
        logger.info(String.format("Expression is called a = %s, b = %s", a, b));
        return a * b;
    }

}
