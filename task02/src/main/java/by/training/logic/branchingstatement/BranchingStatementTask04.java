package by.training.logic.branchingstatement;

public class BranchingStatementTask04 {

    /**
     * Даны три числа a, b, с.
     * Определить, какое из них равно d.
     * Если ни одно не равно d, то найти max(d — a, d — b, d — c)
     *
     * @param a number
     * @param b number
     * @param c number
     * @param d number which compare
     * @return result
     */
    public double defineNumber(double a, double b, double c, double d) {
        if (a == d) {
            return a;
        } else if (b == d) {
            return b;
        } else if (c == d) {
            return c;
        } else {
            if (d - a > d - b && d - a > d - c) {
                return d - a;
            } else if (d - b > d - a && d - b > d - c) {
                return d - b;
            } else {
                return d - c;
            }
        }
    }
}
