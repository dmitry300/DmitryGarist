package by.training.task03.dao;

import by.training.task03.bean.Array;

public interface ArrayDao {
    Array<Double> saveArray(String fileName);
}
