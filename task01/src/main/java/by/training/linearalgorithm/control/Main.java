package by.training.linearalgorithm.control;

import by.training.linearalgorithm.task.*;
import by.training.linearalgorithm.view.Menu;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * приложение по запуску 5 задач
 *
 * @author Dmitry Garist
 */

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Task01LinearAlgorithm task01LinearAlgorithm = new Task01LinearAlgorithm();
        Task02LinearAlgorithm task02LinearAlgorithm = new Task02LinearAlgorithm();
        Task03LinearAlgorithm task03LinearAlgorithm = new Task03LinearAlgorithm();
        Task04LinearAlgorithm task04LinearAlgorithm = new Task04LinearAlgorithm();
        Task05LinearAlgorithm task05LinearAlgorithm = new Task05LinearAlgorithm();
        new Menu().menu();//вызов меню

        boolean isEnable = true;
        while (isEnable) {

            int userInput = getUserInputInt(">> ");
            switch (userInput) {
                case 0: {
                    isEnable = false;
                    break;
                }
                case 1: {
                    double a;
                    double b;
                    double c;
                    double result;

                    System.out.println("Введите наборы значений: ");

                    a = getUserInputDouble("a >> ");
                    b = getUserInputDouble("b >> ");
                    c = getUserInputDouble("c >> ");
                    result = task01LinearAlgorithm.expression(a, b, c);

                    System.out.println(String.format("Значение функции = %s", result));
                    break;
                }
                case 2: {
                    double x1;
                    double y1;
                    double x2;
                    double y2;
                    double result;

                    System.out.println("Введите координаты двух точек: ");

                    x1 = getUserInputDouble("x1 >> ");
                    y1 = getUserInputDouble("y1 >> ");
                    x2 = getUserInputDouble("x2 >> ");
                    y2 = getUserInputDouble("y2 >> ");
                    result = task02LinearAlgorithm.getFunction(x1, x2, y1, y2);

                    System.out.println(String.format("Расстояние между точками: = %s", result));
                    break;
                }
                case 3: {
                    double l;
                    double s;

                    System.out.println("Введите длину окружности: ");
                    l = getUserInputDouble("l >> ");
                    logger.info(String.format("Пользователь ввел: %s >> ", l));
                    try {
                        s = task03LinearAlgorithm.getFunction(l);
                        System.out.println(String.format("Площадь окружности = %s", s));
                    } catch (IllegalArgumentException e) {
                        logger.warn(e);
                    }
                    break;
                }
                case 4: {
                    double angle;

                    System.out.println("Введите радиианный угол: ");
                    angle = getUserInputDouble("angle >> ");
                    logger.info(String.format("Пользователь ввел: %s >> ", angle));

                    System.out.println(String.format("%s гр, %s мин, %s cек", task04LinearAlgorithm.getFunction(angle)[0],
                            task04LinearAlgorithm.getFunction(angle)[1], task04LinearAlgorithm.getFunction(angle)[2]));
                    break;
                }
                case 5: {
                    int number;

                    number = getUserInputInt("Введите четырехзначное число >> ");
                    logger.info(String.format("Пользователь ввел: %s >> ", number));

                    System.out.println("1-ое число отображает произведение четных чисел,2-ое - нечетных.");
                    System.out.println(Arrays.toString(task05LinearAlgorithm.getFunction(number)));
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + userInput);
            }
        }
    }

    /**
     * @param message должен выводится на консоль
     * @return - возращаемое значение(число) веденное пользователем.
     */
    public static double getUserInputDouble(String message) {
        String inputLine = null;
        System.out.print(message);
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() != 0) {
                return Double.parseDouble(inputLine);
            }
        } catch (IOException e) {
            logger.warn("IOException: " + e);
        }
        return 0;

    }

    public static int getUserInputInt(String message) {
        String inputLine = null;
        System.out.print(message);
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() != 0) {
                return Integer.parseInt(inputLine);
            }
        } catch (IOException e) {
            logger.warn("IOException: " + e);
        }
        return 0;

    }
}

