package by.training.task03.bean;

import java.util.Arrays;
import java.util.Objects;

public class Array<T extends Number> {
    private T[] array;

    public Array() {

    }

    public Array(Class<T> type, int length) {
        if (length < 1) {
            throw new IllegalArgumentException();
        } else {
            this.array = (T[]) java.lang.reflect.Array.newInstance(type, length);
        }
    }

    public Array(T[] array) {
        this.array = array;
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
        Array<?> array1 = (Array<?>) o;
        return Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), array);
    }

    @Override
    public String toString() {
        if (array == null) {
            return "";
        }
        return array.getClass().getName() + "Array{" + Arrays.toString(array) + '}';
    }
}
