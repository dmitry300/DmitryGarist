package by.training.control;

import by.training.exception.DivisionByZero;
import by.training.view.ApplicationOutput;
import by.training.view.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        new Menu().menu();
        boolean isEnable = true;
        while (isEnable) {

            int userInput = getUserInputInt(">> ");

            switch (userInput) {
                case 1: {
                    double a;
                    double b;

                    System.out.println("Введите 2 числа, чтобы сравнить их");
                    a = getUserInputDouble(">> ");
                    b = getUserInputDouble(">> ");

                    new ApplicationOutput().outputBranchingStatementTask01(a, b);
                    break;
                }
                case 2: {
                    double a;
                    double b;
                    double c;

                    System.out.println("Введите 3 числа: ");
                    a = getUserInputDouble(">> ");
                    b = getUserInputDouble(">> ");
                    c = getUserInputDouble(">> ");
                    new ApplicationOutput().outputBranchingStatementTask02(a);
                    new ApplicationOutput().outputBranchingStatementTask02(b);
                    new ApplicationOutput().outputBranchingStatementTask02(c);
                    break;
                }
                case 3: {
                    int a;
                    int b;
                    int c;
                    int k;

                    System.out.println("Введите 3 числа и делитель для этих чисел: ");
                    a = getUserInputInt(">> ");
                    b = getUserInputInt(">> ");
                    c = getUserInputInt(">> ");
                    k = getUserInputInt(">> ");
                    try {
                        new ApplicationOutput().outputBranchingStatementTask03(a, b, c, k);
                    }catch (DivisionByZero e){
                        logger.warn(String.format("Division by zero: %s", e));
                    }

                    break;

                }
                case 4: {
                    double a;
                    double b;
                    double c;
                    double d;

                    System.out.println("Введите 3 числа и число, которое будет сравниваться с числами, введенными ранее: ");
                    a = getUserInputDouble(">> ");
                    b = getUserInputDouble(">> ");
                    c = getUserInputDouble(">> ");
                    d = getUserInputDouble(">> ");

                    new ApplicationOutput().outputBranchingStatementTask04(a, b, c, d);
                    break;

                }
                case 5: {
                    double x;

                    System.out.println("Введите аргумент функции: ");
                    x = getUserInputDouble(">> ");

                    new ApplicationOutput().outputBranchingStatementTask05(x);
                    break;

                }
                case 6: {
                    new ApplicationOutput().outputLoopTask01();
                    break;

                }
                case 7: {
                    new ApplicationOutput().outputLoopTask02();
                    break;
                }
                case 8: {
                    double e;

                    System.out.println("Введите входной параметр е(1ый член ряда < 0.25): ");
                    e = getUserInputDouble(">> ");

                    new ApplicationOutput().outputLoopTask03(e);
                    break;
                }
                case 9: {
                    double x;
                    double y;
                    char sign;

                    System.out.println("Введите 2 числа и только потом знак '+,-,*,/': ");
                    x = getUserInputDouble(">> ");
                    y = getUserInputDouble(">> ");
                    sign = getUserInputChar(">> ");

                    try {
                        new ApplicationOutput().outputLoopTask04(x, y, sign);
                    } catch (DivisionByZero e) {
                        logger.warn(String.format("Division by zero: %s", e));
                    }
                    catch (IllegalStateException e) {
                        logger.warn(String.format("not such data: %s", e));
                    }
                    break;
                }
                case 10: {
                    new ApplicationOutput().outputLoopTask05();
                    break;
                }
                case 0: {
                    isEnable = false;
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + userInput);

            }


        }

    }

    public static int getUserInputInt(String message) {
        String inputLine ;
        System.out.print(message);
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() != 0) {
                return Integer.parseInt(inputLine);
            }
        } catch (IOException e) {
            logger.error(String.format("IOException: %s", e));
        }
        return 0;

    }

    public static double getUserInputDouble(String message) {
        String inputLine ;
        System.out.print(message);
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() != 0) {
                return Double.parseDouble(inputLine);
            }
        } catch (IOException e) {
            logger.error(String.format("IOException: %s", e));
        }
        return 0;

    }

    public static char getUserInputChar(String message) {
        char inputLine;
        System.out.print(message);
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = (char) is.read();
            if (inputLine != 0) {
                return inputLine;
            }
        } catch (IOException e) {
            logger.error(String.format("IOException: %s", e));
        }
        return 0;
    }
}
