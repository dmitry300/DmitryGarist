package by.training.task03.service.loader;

import by.training.task03.bean.Array;
import by.training.task03.dao.ArrayDao;
import by.training.task03.dao.factory.DAOFactory;
import by.training.task03.service.LoadingArray;

public class LoaderArray implements LoadingArray {
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    public Array<Double> readArray() {
        ArrayDao arrayDao = daoFactory.getFileArrayDao();
        Array<Double> array = arrayDao.saveArray("C:/Users/KaMo User/IdeaProjects/demomatrix/src/data/dataForArray.txt");

        if (array != null) {
            return array;
        }
        return new Array<>();
    }
}
