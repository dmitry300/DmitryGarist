package by.training.logic.branchingstatement;

import by.training.exception.DivisionByZero;

public class BranchingStatementTask03 {

    /**
     * Определить, делителем каких чисел а, b, с является число k.
     *
     * @param a number
     * @param b number
     * @param c number
     * @param k divider
     * @return number which k divide
     * @throws DivisionByZero
     */
    public int[] divider(int a, int b, int c, int k) throws DivisionByZero {
        int array[] = new int[3];
        int i = 0;
        if(k==0){
            throw new DivisionByZero();
        }
        if (a % k == 0) {
            array[i++] = a;
        }
        if (b % k == 0) {
            array[i++] = b;
        }
        if (c % k == 0) {
            array[i] = c;
        }
        return array;
    }
}
