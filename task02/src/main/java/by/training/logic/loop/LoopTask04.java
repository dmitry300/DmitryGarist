package by.training.logic.loop;

import by.training.exception.DivisionByZero;

public class LoopTask04 {
    /**
     * Написать программу, в которой вводятся два операнда Х и Y и знак операции (+, –, /, *).
     *     Вычислить результат Z в зависимости от знака.
     *     Предусмотреть реакции на возможный неверный знак операции, а также на ввод Y=0 при делении.
     *     Организовать возможность многократных вычислений без перезагрузки программа (т.е. построить цикл).
     *     В качестве символа прекращения вычислений принять‘0’.
     * @param x number
     * @param y number
     * @param sign symbol
     * @return sum/difference/division/multiply
     * @throws DivisionByZero
     * @throws IllegalStateException
     */
    public double calculate(double x, double y, char sign) throws DivisionByZero,IllegalStateException {
        boolean isActive = true;
        while (isActive) {
            switch (sign) {
                case '+': {
                    return x + y;
                }
                case '-': {
                    return x - y;
                }
                case '*': {
                    return x * y;
                }
                case '/': {
                    if(y==0){
                        throw new DivisionByZero();
                    }
                    return x / y;
                }
                case 0: {
                    isActive = false;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + sign);
            }
        }
        return 0;
    }

}
