package by.training.task03.bean;

import java.util.Arrays;

public class Array<T extends Number> {
    private T[] array;

    public Array() {

    }

    public Array(T[] array) {
        this.array = array;
    }

    public Array(Class<T> type, int length) throws IllegalArgumentException {
        if (length < 1) {
            throw new IllegalArgumentException();
        } else {
            this.array = (T[]) java.lang.reflect.Array.newInstance(type, length);
        }

    }

    public T[] getArray() {
        return this.array;
    }

    public int getLength() {
        return this.array.length;
    }

    public T getElement(int i) throws IllegalArgumentException {
        if (checkRange(i)) {
            return this.array[i];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setElement(int i, T value) throws IllegalArgumentException {
        if (checkRange(i)) {
            this.array[i] = value;
        } else {
            throw new IllegalArgumentException();
        }
    }


    private boolean checkRange(int i) {// check array range
        return i >= 0 && i <= array.length - 1;
    }

    public void swap(int left, int right) {
        T tmp = this.array[left];
        this.array[left] = this.array[right];
        this.array[right] = tmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array<T> array1 = (Array<T>) o;
        for (int i = 0; i < array1.getLength(); i++) {
            if (array1.getElement(i) != array[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        if (array == null) {
            return "";
        }
        return array.getClass().getName() + "Array{" + Arrays.toString(array) + '}';
    }
}
