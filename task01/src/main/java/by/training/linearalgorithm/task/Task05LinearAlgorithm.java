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
     * @param number четырехзначное число
     * @return массив частных произведений[четное, нечетное]
     */
    public int[] getFunction(int number) {
        int oddDigit = 1;
        int evenDigit = 1;
        int array[] = new int[2];
        String result;

        while (number != 0) {
            int tmp = number % 10;
            number /= 10;
            if (tmp % 2 == 0) {
                evenDigit *= tmp;
            } else {
                oddDigit *= tmp;
            }
        }
        array[0] = evenDigit;
        array[1] = oddDigit;

        return array;
    }


}
