package by.training.task03.service;

import by.training.task03.bean.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.DAOFactory;

public class MergeSort {
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    /**
     * @param array - input array
     * @param left  - index of array,where sort starts
     * @param right - index of array,where sort ends
     * @return sorted array
     */
    public Array<Number> sortIncreasing(Array<Number> array, int left, int right) {
        if (array == null) {
            ArrayDao arrayDao = daoFactory.getFileArrayDao();
            array = arrayDao.saveArray();
        }
        if (right <= left) {
            return null;
        } else {
            int mid = (left + right) / 2;
            sortIncreasing(array, left, mid);
            sortIncreasing(array, mid + 1, right);
            merge1(array, left, mid, right);
            return array;
        }

    }

    /**
     * @param array- input array
     * @param left   - begin of left half of array
     * @param mid    - begin/end for 1/2 half of array
     * @param right- end of right half of array
     */
    public void merge1(Array<Number> array, int left, int mid, int right) {
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;
        // создаем временные подмассивы
        Array<Number> leftArray = new Array<>(Number.class, lengthLeft);
        Array<Number> rightArray = new Array<>(Number.class, lengthRight);

        for (int i = 0; i < lengthLeft; i++) {
            leftArray.setElement(i, array.getElement(left + i));
        }
        for (int i = 0; i < lengthRight; i++) {
            rightArray.setElement(i, array.getElement(mid + i + 1));
        }
        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;
        // копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray.getElement(leftIndex).doubleValue() < rightArray.getElement(rightIndex).doubleValue()) {
                    array.setElement(i, leftArray.getElement(leftIndex));
                    leftIndex++;
                } else {
                    array.setElement(i, rightArray.getElement(rightIndex));
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array.setElement(i, leftArray.getElement(leftIndex));
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array.setElement(i, rightArray.getElement(rightIndex));
                rightIndex++;
            }
        }
    }

    /**
     * @param array- input array
     * @param left   - index of array,where sort starts
     * @param right  - index of array,where sort ends
     * @return sorted array
     */
    public Array<Number> sortDecreasing(Array<Number> array, int left, int right) {
        if (array == null) {
            ArrayDao arrayDao = daoFactory.getFileArrayDao();
            array = arrayDao.saveArray();
        }
        if (right <= left) {
            return null;
        } else {
            int mid = (left + right) / 2;
            sortDecreasing(array, left, mid);
            sortDecreasing(array, mid + 1, right);
            merge2(array, left, mid, right);
            return array;
        }
    }

    /**
     * @param array- input array
     * @param left   - begin of left half of array
     * @param mid    - begin/end for 1/2 half of array
     * @param right- end of right half of array
     */
    public void merge2(Array<Number> array, int left, int mid, int right) {
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;
        // создаем временные подмассивы
        Array<Number> leftArray = new Array<>(Number.class, lengthLeft);
        Array<Number> rightArray = new Array<>(Number.class, lengthRight);
        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++) {
            leftArray.setElement(i, array.getElement(left + i));
        }
        for (int i = 0; i < lengthRight; i++) {
            rightArray.setElement(i, array.getElement(mid + i + 1));
        }
        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;
        // копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray.getElement(leftIndex).doubleValue() > rightArray.getElement(rightIndex).doubleValue()) {
                    array.setElement(i, leftArray.getElement(leftIndex));
                    leftIndex++;
                } else {
                    array.setElement(i, rightArray.getElement(rightIndex));
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array.setElement(i, leftArray.getElement(leftIndex));
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array.setElement(i, rightArray.getElement(rightIndex));
                rightIndex++;
            }
        }
    }
}
