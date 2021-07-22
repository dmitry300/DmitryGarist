package by.training.task05.dao.impl;

import by.training.task05.bean.Ball;
import by.training.task05.dao.BallDao;
import by.training.task05.dao.exception.DaoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallDaoImpl implements BallDao {
    private static final Pattern DELIMITER = Pattern.compile("\\s*;\\s*");

    @Override
    public List<Ball> saveBall(String fileName) throws DaoException {
        List<String> ballData;
        Path path = Paths.get("resources\\data.txt");
        try (Stream<String> lineStream = Files.lines(path)) {
            ballData = lineStream.filter(x -> !x.startsWith("#")).distinct().collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException(e);
        }
        List<Ball> listBall = new ArrayList<>();
        for (String ballDatum : ballData) {
            Ball ball = new Ball();
            Ball.Point point = ball.new Point();
            String[] s = ballDatum.split(String.valueOf(DELIMITER));
            ball.setId(Long.parseLong(s[0]));
            ball.setRadius(Double.parseDouble(s[1]));
            point.setXCoordinate(Double.parseDouble(s[2]));
            point.setYCoordinate(Double.parseDouble(s[3]));
            point.setZCoordinate(Double.parseDouble(s[4]));
            ball.setPoint(point);
            listBall.add(ball);
        }
        return listBall;
    }
}
