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
        logger.info(String.format("BranchingStatementTask01, user data: %s %s", a, b));
        System.out.println(new BranchingStatementTask01().equalsTwoNumber(a, b));
    }

    public void outputBranchingStatementTask02(double x) {
        logger.info(String.format("BranchingStatementTask02, user data: %s", x));
        System.out.println(new BranchingStatementTask02().powFunction(x));
    }

    public void outputBranchingStatementTask03(int a, int b, int c, int k)throws DivisionByZero {
        logger.info(String.format("BranchingStatementTask03, user data: %s %s %s %s", a, b, c, k));
        System.out.println(Arrays.toString(new BranchingStatementTask03().divider(a, b, c, k)));
    }

    public void outputBranchingStatementTask04(double a, double b, double c, double d) {
        logger.info(String.format("BranchingStatementTask04, user data: %s %s %s %s", a, b, c, d));
        System.out.println(new BranchingStatementTask04().defineNumber(a, b, c, d));
    }

    public void outputBranchingStatementTask05(double x) {
        logger.info(String.format("BranchingStatementTask05, user data: %s", x));
        System.out.println(new BranchingStatementTask05().defineFunction(x));
    }

    public void outputLoopTask01() {
        System.out.println(Arrays.toString(new LoopTask01().evenNumber()));
    }

    public void outputLoopTask02(int result) {
        System.out.println(result);
    }

    public void outputLoopTask03(double e) {
        logger.info(String.format("LoopTask03, user data: %s", e));
        System.out.println(new LoopTask03().sumMembersOfNumbers(e));
    }

    public void outputLoopTask04(double x, double y, char sign) throws DivisionByZero,IllegalStateException {
        logger.info(String.format("LoopTask04, user data: %s %s %s", x, y, sign));
        System.out.println(new LoopTask04().calculate(x, y, sign));
    }

    public void outputLoopTask05() {
        System.out.println(Arrays.toString(new LoopTask05().fourDigitNumber()));
    }
}

