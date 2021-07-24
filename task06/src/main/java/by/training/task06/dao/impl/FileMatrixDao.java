package by.training.task06.dao.impl;

import by.training.task06.bean.MatrixException;
import by.training.task06.bean.SquareMatrix;
import by.training.task06.dao.MatrixDao;
import by.training.task06.dao.exception.DaoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileMatrixDao implements MatrixDao {
    private static final Pattern DELIMITER = Pattern.compile("\\s+");

    /**
     * @param fileName file being transferred
     * @return matrix
     * @throws DaoException exception from dao
     */
    @Override
    public SquareMatrix saveMatrix(String fileName) throws DaoException {
        SquareMatrix matrix;
        List<String> listData;
        Path path = Paths.get("src/main/resources/matrix");
        try (Stream<String> lineStream = Files.lines(path)) {
            listData = lineStream.filter(x -> !x.startsWith("#")).collect(Collectors.toList());
            int row = 0;
            int sizeMatrix = listData.get(0).split(String.valueOf(DELIMITER)).length;
            matrix = new SquareMatrix(sizeMatrix, sizeMatrix);
            for (String rowDatum : listData) {
                String[] s = rowDatum.split(String.valueOf(DELIMITER));

                for (int i = 0; i < s.length; i++) {
                    matrix.setElement(row, i, Double.parseDouble(s[i]));
                }
                row++;
            }
            return matrix;
        } catch (IOException | MatrixException e) {
            throw new DaoException("Error reading file: " + e);
        }
    }
}

