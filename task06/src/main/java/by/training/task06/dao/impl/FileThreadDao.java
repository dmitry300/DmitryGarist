package by.training.task06.dao.impl;

import by.training.task06.dao.ThreadDao;
import by.training.task06.dao.exception.DaoException;
import by.training.task06.bean.ThreadBean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileThreadDao implements ThreadDao {
    private static final Pattern DELIMITER = Pattern.compile("\\s+");

    /**
     * @param fileName file being transferred
     * @return threadList list of thread beans
     * @throws DaoException exception from dao
     */
    @Override
    public List<ThreadBean> saveThreadNumber(String fileName) throws DaoException {
        List<ThreadBean> threadList;
        List<String> listData;
        Path path = Paths.get("src/main/resources/" + fileName);
        try (Stream<String> lineStream = Files.lines(path)) {
            listData = lineStream.filter(x -> !x.startsWith("#")).collect(Collectors.toList());
            threadList = new ArrayList<>();
            for (String datum : listData) {
                String[] s = datum.split(String.valueOf(DELIMITER));
                for (String value : s) {
                    ThreadBean thread = new ThreadBean(Double.parseDouble(value));
                    threadList.add(thread);
                }
            }
            return threadList;
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }
}
