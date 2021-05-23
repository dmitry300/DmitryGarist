package by.training.linearalgorithm.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 36. Найти частное произведений четных и нечетных цифр четырехзначного числа.
 *
 * @author Dmitry Garist
 */

public class Task05LinearAlgorithm {

    private static final Logger logger = LogManager.getLogger(Task05LinearAlgorithm.class);

    /**
     * @param number 4ех-значное число
     */
    public String getFunction(int number) {
        int oddDigit = 1;
        int evenDigit = 1;
        String result ;

        while (number != 0) {
            int tmp = number % 10;
            number /= 10;
            if (tmp % 2 == 0) {
                evenDigit *= tmp;
            } else {
                oddDigit *= tmp;
            }
        }
        logger.info("Произведение четных: " + evenDigit);
        logger.info("Произведение нечетных: " + oddDigit);
        return "oddDigit  evenDigit";
    }


}
