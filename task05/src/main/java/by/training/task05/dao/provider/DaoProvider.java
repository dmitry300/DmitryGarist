package by.training.task05.dao.provider;

import by.training.task05.dao.BallDao;
import by.training.task05.dao.impl.BallDaoImpl;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();
    private final BallDao ballDao = new BallDaoImpl();

    public static DaoProvider getInstance() {
        return instance;
    }

    public BallDao getBallDao() {
        return ballDao;
    }
}
