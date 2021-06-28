package by.training.task03.dao.impl;

import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;
import by.training.task03.dao.MatrixDao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileMatrixDao implements MatrixDao {
    private static final Logger logger = LogManager.getLogger(FileMatrixDao.class);

    @Override
    public Matrix<Double> saveMatrix(String fileName) {
        Matrix<Double> matrix = null;
        BufferedReader br = null;
        BufferedReader br1 = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            br1 = new BufferedReader(new FileReader(fileName));
            String tmp;
            int row = 0;
            tmp = br1.readLine();
            String[] s1 = tmp.split("\\s+");
            matrix = new Matrix<>(Double.class, s1.length, s1.length);
            while ((tmp = br.readLine()) != null) {
                s1 = tmp.split("\\s+");
                for (int i = 0; i < s1.length; i++) {
                    matrix.setElement(row, i, Double.parseDouble(s1[i]));
                }
                row++;
            }
        } catch (IOException | MatrixException e) {
            logger.error(String.format("Error reading file or creating matrix %s", e));
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
            if (br1 != null) {
                try {
                    br1.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }
        return matrix;
    }
}
