package by.training.barbershop.service.impl;

import by.training.barbershop.bean.*;
import by.training.barbershop.dao.*;
import by.training.barbershop.dao.exception.DaoException;
import by.training.barbershop.dao.impl.AbstractDao;
import by.training.barbershop.dao.impl.DaoFactory;
import by.training.barbershop.service.OrderService;
import by.training.barbershop.service.exception.ServiceException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public boolean addOrder(Order order) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) orderDao);
        if (order != null) {
            try {
                order.setDateTime(Timestamp.valueOf(LocalDateTime.now()));
                orderDao.create(order);
                transactionDao.commit();
                return true;
            } catch (DaoException | SQLException e) {
                transactionDao.rollback();
                throw new ServiceException(e);
            }finally {
                transactionDao.endTransaction();
            }
        }
        return false;
    }

    @Override
    public List<Order> findAllActiveOrder(boolean active) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        BarberDao barberDao = daoFactory.getBarberDao();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction(
                (AbstractDao) orderDao,
                (AbstractDao) haircutDao,
                (AbstractDao) barberDao,
                (AbstractDao) userDao,
                (AbstractDao) userInfoDao);
        try {
            List<Order> orders = orderDao.findAll();
            for (var order : orders) {
                Haircut haircut = haircutDao.findEntityById(order.getHaircut().getId());
                order.setHaircut(haircut);
                Barber barber = barberDao.findEntityById(order.getBarber().getId());
                order.setBarber(barber);
                User user = userDao.findEntityById(order.getUser().getId());
                UserInfo userInfo = userInfoDao.findEntityById(order.getUser().getId());
                user.setUserInfo(userInfo);
                order.setUser(user);
            }
            if (active) {
                orders.removeIf(order -> order.getDateTimePlane().before(Timestamp.valueOf(LocalDateTime.now())));

            } else {
                orders.removeIf(order -> order.getDateTimePlane().after(Timestamp.valueOf(LocalDateTime.now())));
            }
            transactionDao.commit();
            return orders;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e);
        } finally {
            transactionDao.endTransaction();
        }
    }

    @Override
    public List<Order> findOrderByUserId(int userId) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
//        UserDao userDao = daoFactory.getUserDao();
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        BarberDao barberDao = daoFactory.getBarberDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction(
                (AbstractDao) orderDao,
//                (AbstractDao) userDao,
                (AbstractDao) haircutDao,
                (AbstractDao) barberDao);
        try {
            List<Order> orders = orderDao.findEntityByUserId(userId);
            for (var order : orders) {
//                User user = userDao.findEntityById(order.getUser().getId());
//                order.setUser(user);
                Haircut haircut = haircutDao.findEntityById(order.getHaircut().getId());
                order.setHaircut(haircut);
                Barber barber = barberDao.findEntityById(order.getBarber().getId());
                order.setBarber(barber);
            }
            transactionDao.commit();
            return orders;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e);
        } finally {
            transactionDao.endTransaction();
        }
    }

    @Override
    public boolean removeOrderById(int orderId) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) orderDao);
        try {
            boolean isDeleted = orderDao.delete(orderId);
            transactionDao.commit();
            transactionDao.endTransaction();
            return isDeleted;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e);
        }finally {
            transactionDao.endTransaction();
        }
    }

    @Override
    public boolean changeStatusOrder(Order order, OrderStatus orderStatus) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) orderDao);
        order.setStatus(orderStatus);
        try {
            Order orderUpdated = orderDao.update(order);
            transactionDao.commit();
            transactionDao.endTransaction();
            return orderUpdated != null;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e);
        } finally {
            transactionDao.end();
        }
    }

    @Override
    public Order findOrderById(int id) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        BarberDao barberDao = daoFactory.getBarberDao();
        UserDao userDao = daoFactory.getUserDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction(
                (AbstractDao) orderDao,
                (AbstractDao) haircutDao,
                (AbstractDao) barberDao,
                (AbstractDao) userDao);
        try {
            Order order = orderDao.findEntityById(id);
            Haircut haircut = haircutDao.findEntityById(order.getHaircut().getId());
            Barber barber = barberDao.findEntityById(order.getBarber().getId());
            User user = userDao.findEntityById(order.getUser().getId());
            order.setHaircut(haircut);
            order.setBarber(barber);
            order.setUser(user);
            transactionDao.commit();
            transactionDao.endTransaction();
            return order;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e);
        } finally {
            transactionDao.end();
        }
    }

    @Override
    public boolean updateOrder(Order order) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) orderDao);
        try {
            orderDao.update(order);
            transactionDao.commit();
            return true;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e);
        } finally {
            transactionDao.end();
        }
    }

    @Override
    public List<Order> findActiveOrderByStatus(OrderStatus status, boolean active) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        BarberDao barberDao = daoFactory.getBarberDao();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction(
                (AbstractDao) orderDao,
                (AbstractDao) haircutDao,
                (AbstractDao) barberDao,
                (AbstractDao) userDao,
                (AbstractDao) userInfoDao);
        try {
            List<Order> orders = orderDao.findEntityByStatus(status);
            for (var order : orders) {
                Haircut haircut = haircutDao.findEntityById(order.getHaircut().getId());
                order.setHaircut(haircut);
                Barber barber = barberDao.findEntityById(order.getBarber().getId());
                order.setBarber(barber);
                User user = userDao.findEntityById(order.getUser().getId());
                UserInfo userInfo = userInfoDao.findEntityById(order.getUser().getId());
                user.setUserInfo(userInfo);
                order.setUser(user);
            }
            if (active) {
                orders.removeIf(order -> order.getDateTimePlane().before(Timestamp.valueOf(LocalDateTime.now())));

            } else {
                orders.removeIf(order -> order.getDateTimePlane().after(Timestamp.valueOf(LocalDateTime.now())));
            }
            transactionDao.commit();
            return orders;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e);
        } finally {
            transactionDao.endTransaction();
        }
    }
}
