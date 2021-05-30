package by.training.logic.loop;

public class LoopTask01 {
    /**
     * С помощью оператора while напишите программу вывода всех четных чисел в диапазоне от 2 до 100 включительно.
     * @return массив чисел
     */
    public int[] evenNumber() {
        int array[] = new int[50];
        int i=0;
        int n = 0;
        while (n < 100) {
            n += 2;
            array[i]=n;
        }
       return array;
    }

}
