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
                transactionDao.endTransaction();
                return true;
            } catch (DaoException | SQLException e) {
                transactionDao.rollback();
                throw new ServiceException(e);
            }
        }
        return false;
    }

    @Override
    public List<Order> findAllOrder() throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) orderDao);
        try {
            return orderDao.findAll();
        } catch (DaoException e) {
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
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) orderDao);
        try {
            Order order = orderDao.findEntityById(id);
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
}
