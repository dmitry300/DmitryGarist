package by.training.logic.branchingstatement;

public class BranchingStatementTask05 {

    /**
     * Вычислить значение функции:(система) x^2 - 3x + 9, если x<=3 и 1/x^3+6, если x>3
     *
     * @param x
     * @return definition of the equation
     */
    public double defineFunction(double x) {
        if (x <= 3) {
            return Math.pow(x, 2) - 3 * x + 9;
        } else {
            return 1 / (Math.pow(x, 3) + 6);
        }
    }
}
