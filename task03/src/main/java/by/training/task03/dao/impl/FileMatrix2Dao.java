package by.training.task03.dao.impl;

import by.training.task03.bean.Matrix;
import by.training.task03.bean.MatrixException;
import by.training.task03.dao.MatrixDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileMatrix2Dao implements MatrixDao {
    private static final Logger logger = LogManager.getLogger(FileMatrix2Dao.class);

    @Override
    public Matrix<Number> saveMatrix() {
        Matrix<Number> matrix = null;
        BufferedReader br = null;
        try {
            matrix = new Matrix<>(Number.class, 6, 6);
            br = new BufferedReader(new FileReader("C:/Users/KaMo User/IdeaProjects/demomatrix/src/data/dataForMatrix2.txt"));
            String tmp;
            int row = 0;
            while ((tmp = br.readLine()) != null) {
                String[] s = tmp.split("\\s");
                for (int i = 0; i < s.length; i++) {
                    matrix.setElement(row, i, Double.parseDouble(s[i]));
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
        }
        return matrix;
    }
}
