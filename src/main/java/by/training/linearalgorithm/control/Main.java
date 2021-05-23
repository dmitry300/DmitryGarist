package by.training.linearalgorithm.control;

import by.training.linearalgorithm.task.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        boolean isEnable = true;
        while (isEnable) {
            menu();
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

                    logger.info(String.format("Значение функции = %s", result));
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

                    logger.info(String.format("Расстояние между точками: = %s", result));
                    break;
                }
                case 3: {
                    double l;
                    double s;

                    System.out.println("Введите длину окружности: ");
                    l = getUserInputDouble("l >> ");
                    logger.info(String.format("Пользователь ввел: %s >> ", l));
                    s = task03LinearAlgorithm.getFunction(l);

                    logger.info(String.format("Площадь окружности = %s", s));
                    break;
                }
                case 4: {
                    double angle;

                    System.out.println("Введите радиианный угол: ");
                    angle = getUserInputDouble("angle >> ");
                    logger.info(String.format("Пользователь ввел: %s >> ", angle));

                    task04LinearAlgorithm.getFunction(angle);
                    break;
                }
                case 5: {
                    int number;

                    number = getUserInputInt("Введите четырехзначное число >> ");
                    logger.info(String.format("Пользователь ввел: %s >> ", number));

                    task05LinearAlgorithm.getFunction(number);
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

    public static void menu() {
        System.out.println("Выберете номер задачи из предложенных!");
        System.out.println("1. (4) Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.");
        System.out.println("2. (12) Вычислить расстояние между двумя точками с данными координатами (х1, у1) и (x2, у2).");
        System.out.println("3. (20) Известна длина окружности. Найти площадь круга, ограниченного этой окружностью.");
        System.out.println("4. (28) Составить программу перевода радианной меры угла в градусы, минуты и секунды.");
        System.out.println("5. (36) Найти частное произведений четных и нечетных цифр четырехзначного числа.");
        System.out.println("Нажмите 0 для выхода.");
    }
}
