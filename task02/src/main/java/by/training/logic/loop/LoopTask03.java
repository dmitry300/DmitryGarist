package by.training.logic.loop;

public class LoopTask03 {
    /**
     * Даны числовой ряд и некоторое число е.
     * Найти сумму тех членов ряда, модуль которых больше или равен заданному е.
     * Общий член ряда имеет вид: an = 1 / (3n - 2)(3n + 1)
     *
     * @param e input number
     * @return sum of the members of the series
     */
    public double sumMembersOfNumbers(double e) {
        double n = 0;
        double sum = 0;
        double an = 0.25; //0.25 - 1ый член ряда

        if (e <= 0) {
            sum = 1.0 / 3.0;//сходимый ряд
            return sum;
        } else {
            while (an >= e) {
                n++;
                an = 1 / ((3 * n - 2) * (3 * n + 1));
                sum += an;

            }
        }
        return sum;
    }

}
