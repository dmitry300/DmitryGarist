package by.training.logic.loop;

public class LoopTask05 {
    /**
     * Два двузначных числа, записанных одно за другим,
     * образуют четырёхзначное число, которое делится на их произведение.
     * Найти эти числа.
     *
     * @return массив чиссел
     */
    public int[] fourDigitNumber() {
        int a = 10;
        int b = 10;
        int[] array = new int[4];
        int i = 0;

        while (a < 100) {
            while (b < 100) {
                if ((a * 100 + b) % (a * b) == 0) {
                    array[i] = a;
                    array[i + 1] = b;
                    i += 2;
                }
                b++;
            }
            a++;
            b = 10;
        }
        return array;
    }
}
