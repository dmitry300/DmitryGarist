package by.training.task03.dao.impl;

import by.training.task03.bean.Array;
import by.training.task03.dao.ArrayDao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class FileArrayDao implements ArrayDao {
    private static final Logger logger = LogManager.getLogger(FileArrayDao.class);

    @Override
    public Array<Number> saveArray() {
        Array<Number> array = new Array<>(Number.class,29);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:/Users/KaMo User/IdeaProjects/demomatrix/src/data/dataForArray.txt"));
            String tmp;
            while ((tmp = br.readLine()) != null) {
                String[] s = tmp.split("\\s+");
                for (int i = 0; i < s.length; i++) {
                    array.setElement(i, Double.parseDouble(s[i]));
                }
            }
        } catch (IOException e) {
            logger.error(String.format("Error reading file %s", e));
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error(e);
                }

            }

        }
        return array;
    }

}
