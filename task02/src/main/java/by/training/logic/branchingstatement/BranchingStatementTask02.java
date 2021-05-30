package by.training.logic.branchingstatement;

public class BranchingStatementTask02 {

    /**
     * Даны три действительных числа.
     * Возвести в квадрат те из них, значения которых неотрицательны, и в четвертую cтепень — отрицательные.
     *
     * @param x any number
     * @return exponentiation
     */
    public double powFunction(double x) {
        if (x >= 0) {
            return Math.pow(x, 2);
        } else {
            return Math.pow(x, 4);
        }
    }
}
