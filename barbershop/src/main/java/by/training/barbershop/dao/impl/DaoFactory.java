package by.training.barbershop.dao.impl;

import by.training.barbershop.dao.*;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final UserDao userDao = new UserDaoImpl();
    private final UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private final BarberDao barberDao = new BarbersDaoImpl();
    private final ReviewDao reviewDao = new ReviewDaoImpl();
    private final HaircutDao haircutDao = new HaircutDaoImpl();
    private final OrderDao orderDao = new OrdersDaoImpl();
    private final Transaction transaction = new TransactionImpl();

    private DaoFactory() {

    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public BarberDao getBarberDao() {
        return barberDao;
    }

    public HaircutDao getHaircutDao() {
        return haircutDao;
    }

    public Transaction getTransactionDao() {
        return transaction;
    }

    public ReviewDao getReviewDao() {
        return reviewDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }
}
