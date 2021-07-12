package by.training.task03.service.loader;


import by.training.task03.bean.Matrix;
import by.training.task03.dao.MatrixDao;
import by.training.task03.dao.factory.DAOFactory;
import by.training.task03.service.LoadingMatrix;

import java.util.LinkedList;
import java.util.List;

public class LoaderMatrix implements LoadingMatrix { //2 лоудера
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public List<Matrix<Double>> readTwoMatrix() {
        MatrixDao matrixDao = daoFactory.getFileMatrixDao();
        Matrix<Double> matrixFirst = matrixDao.saveMatrix("C:/Users/KaMo User/IdeaProjects/demomatrix/src/data/dataForMatrix1.txt");
        Matrix<Double> matrixSecond = matrixDao.saveMatrix("C:/Users/KaMo User/IdeaProjects/demomatrix/src/data/dataForMatrix2.txt");
        List<Matrix<Double>> listMatrix = new LinkedList<>();
        listMatrix.add(matrixFirst);
        listMatrix.add(matrixSecond);
        return listMatrix;
    }
}