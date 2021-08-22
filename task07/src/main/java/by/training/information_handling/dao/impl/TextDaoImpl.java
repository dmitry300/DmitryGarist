package by.training.information_handling.dao.impl;

import by.training.information_handling.dao.TextDao;
import by.training.information_handling.dao.exception.DaoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextDaoImpl implements TextDao {
    /**
     * @param fileName file being transferred
     * @return listData
     * @throws DaoException exception from dao
     */
    @Override
    public String saveText(String fileName) throws DaoException {
        List<String> listData;
        Path path = Paths.get("src/main/resources/" + fileName);
        try (Stream<String> lineStream = Files.lines(path)) {
            listData = lineStream.collect(Collectors.toList());
            StringBuilder stringBuilder = new StringBuilder();
            for (var data : listData) {
                stringBuilder.append(data);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }
}
