package by.training.view;

import by.training.exception.DivisionByZero;
import by.training.logic.branchingstatement.*;
import by.training.logic.loop.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ApplicationOutput {

    private static final Logger logger = LogManager.getLogger(ApplicationOutput.class);

    public void outputBranchingStatementTask01(double a, double b) {
        boolean result = new BranchingStatementTask01().equalsTwoNumber(a, b);
        logger.info(String.format("BranchingStatementTask01, user data: %s %s, result: %s", a, b, result));
        System.out.println(result);
    }

    public void outputBranchingStatementTask02(double x) {
        double result = new BranchingStatementTask02().powFunction(x);
        logger.info(String.format("BranchingStatementTask02, user data: %s, result: %s", x, result));
        System.out.println(result);
    }

    public void outputBranchingStatementTask03(int a, int b, int c, int k) throws DivisionByZero {
        int[] arrayResult = new BranchingStatementTask03().divider(a, b, c, k);
        logger.info(String.format("BranchingStatementTask03, user data: %s %s %s %s, result: %s", a, b, c, k, Arrays.toString(arrayResult)));
        System.out.println(Arrays.toString(arrayResult));
    }

    public void outputBranchingStatementTask04(double a, double b, double c, double d) {
        double result = new BranchingStatementTask04().defineNumber(a, b, c, d);
        logger.info(String.format("BranchingStatementTask04, user data: %s %s %s %s, result = %s", a, b, c, d, result));
        System.out.println(result);
    }

    public void outputBranchingStatementTask05(double x) {
        double result = new BranchingStatementTask05().defineFunction(x);
        logger.info(String.format("BranchingStatementTask05, user data: %s, result: %s", x, result));
        System.out.println(result);
    }

    public void outputLoopTask01() {
        int[] arrayResult = new LoopTask01().evenNumber();
        logger.info(String.format("LoopTask01, result: %s", Arrays.toString(arrayResult)));
        System.out.println(Arrays.toString(arrayResult));
    }

    public void outputLoopTask02() {
        int result = new LoopTask02().sequence();
        logger.info(String.format("LoopTask02, result: %s", result));
        System.out.println(result);
    }

    public void outputLoopTask03(double e) {
        double result = new LoopTask03().sumMembersOfNumbers(e);
        logger.info(String.format("LoopTask03, user data: %s, result: %s", e, result));
        System.out.println(result);
    }

    public void outputLoopTask04(double x, double y, char sign) throws DivisionByZero, IllegalStateException {
        double result = new LoopTask04().calculate(x, y, sign);
        logger.info(String.format("LoopTask04, user data: %s %s %s, result: %s", x, y, sign, result));
        System.out.println(result);
    }

    public void outputLoopTask05() {
        int[] arrayResult = new LoopTask05().fourDigitNumber();
        logger.info(String.format("LoopTask05, result: %s", Arrays.toString(arrayResult)));
        System.out.println(Arrays.toString(arrayResult));
    }
}

