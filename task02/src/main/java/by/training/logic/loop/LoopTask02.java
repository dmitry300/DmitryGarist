package by.training.logic.loop;

public class LoopTask02 {

    /**
     * Последовательность аn строится так: а1 = 1, an = 6 + а(n-1)
     * Для каждого n > 1 составьте программу нахождения произведения первых 10 членов этой последовательности.
     *
     * @return multiply members of the sequence
     */
    public int sequence() {
        int result = 1;
        int a1 = 1;
        int n = 0;
        while (n < 10) {
            result *= (6 + a1);
            a1 += 6;
            n++;
        }
     return result;
    }
}
