package by.training.barbershop.service.impl;

import by.training.barbershop.bean.*;
import by.training.barbershop.dao.*;
import by.training.barbershop.dao.exception.DaoException;
import by.training.barbershop.dao.exception.DatabaseConnectionException;
import by.training.barbershop.dao.impl.AbstractDao;
import by.training.barbershop.dao.impl.DaoFactory;
import by.training.barbershop.service.OrderService;
import by.training.barbershop.service.exception.ServiceException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static final int ITEMS_ON_PAGE_COUNT = 3;
    private static final int MIN_PAGE_COUNT = 1;
    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private final Transaction transaction = daoFactory.getTransactionDao();

    @Override
    public boolean addOrder(Order order) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        if (order != null) {
            try {
                transaction.initTransaction((AbstractDao) orderDao);
                order.setDateTime(Timestamp.valueOf(LocalDateTime.now()));
                orderDao.create(order);
                transaction.commit();
                return true;
            } catch (DaoException | SQLException | DatabaseConnectionException e) {
                transaction.rollback();
                throw new ServiceException(e);
            } finally {
                transaction.endTransaction();
            }
        }
        return false;
    }

    @Override
    public List<Order> findBookedTimePoints(LocalDate date) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        BarberDao barberDao = daoFactory.getBarberDao();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        try {
            transaction.initTransaction(
                    (AbstractDao) orderDao,
                    (AbstractDao) haircutDao,
                    (AbstractDao) barberDao,
                    (AbstractDao) userDao,
                    (AbstractDao) userInfoDao);
            List<Order> orders = orderDao.findEntityByDatePlane(date);
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
            transaction.commit();
            return orders;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public List<Order> findAllOrder(boolean active) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        BarberDao barberDao = daoFactory.getBarberDao();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        try {
            transaction.initTransaction(
                    (AbstractDao) orderDao,
                    (AbstractDao) haircutDao,
                    (AbstractDao) barberDao,
                    (AbstractDao) userDao,
                    (AbstractDao) userInfoDao);
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
            transaction.commit();
            return orders;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public List<Order> findOrderByPage(List<Order> orders, int pageNumber) {
        int fromIndex = (pageNumber - 1) * ITEMS_ON_PAGE_COUNT;
        int toIndex = fromIndex + ITEMS_ON_PAGE_COUNT;
        while (toIndex > orders.size()) {
            toIndex = checkToIndex(toIndex, orders);
        }
        if (fromIndex == toIndex) {
            orders.subList(0, toIndex).clear();
        } else {
            orders = orders.subList(fromIndex, toIndex);
        }
        return orders;
    }

    @Override
    public int calcPagesCountForOrders(int ordersCount) {
        int result = (int) Math.ceil((double) ordersCount / ITEMS_ON_PAGE_COUNT);
        return result != 0 ? result : MIN_PAGE_COUNT;
    }

    private int checkToIndex(int toIndex, List<Order> orders) {
        if (toIndex > orders.size()) {
            return --toIndex;
        }
        return 0;
    }

    @Override
    public List<Order> findOrderByUserId(int userId) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        BarberDao barberDao = daoFactory.getBarberDao();
        try {
            transaction.initTransaction(
                    (AbstractDao) orderDao,
                    (AbstractDao) haircutDao,
                    (AbstractDao) barberDao);
            List<Order> orders = orderDao.findEntityByUserId(userId);
            for (var order : orders) {
                Haircut haircut = haircutDao.findEntityById(order.getHaircut().getId());
                order.setHaircut(haircut);
                Barber barber = barberDao.findEntityById(order.getBarber().getId());
                order.setBarber(barber);
            }
            transaction.commit();
            return orders;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean removeOrderById(int orderId) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        try {
            transaction.initTransaction((AbstractDao) orderDao);
            boolean isDeleted = orderDao.delete(orderId);
            transaction.commit();
            transaction.endTransaction();
            return isDeleted;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean changeStatusOrder(Order order, OrderStatus orderStatus) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        order.setStatus(orderStatus);
        try {
            transaction.initTransaction((AbstractDao) orderDao);
            Order orderUpdated = orderDao.update(order);
            transaction.commit();
            transaction.endTransaction();
            return orderUpdated != null;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.end();
        }
    }

    @Override
    public Order findOrderById(int id) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        BarberDao barberDao = daoFactory.getBarberDao();
        UserDao userDao = daoFactory.getUserDao();
        try {
            transaction.initTransaction(
                    (AbstractDao) orderDao,
                    (AbstractDao) haircutDao,
                    (AbstractDao) barberDao,
                    (AbstractDao) userDao);
            Order order = orderDao.findEntityById(id);
            Haircut haircut = haircutDao.findEntityById(order.getHaircut().getId());
            Barber barber = barberDao.findEntityById(order.getBarber().getId());
            User user = userDao.findEntityById(order.getUser().getId());
            order.setHaircut(haircut);
            order.setBarber(barber);
            order.setUser(user);
            transaction.commit();
            transaction.endTransaction();
            return order;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.end();
        }
    }

    @Override
    public boolean updateOrder(Order order) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        try {
            transaction.initTransaction((AbstractDao) orderDao);
            orderDao.update(order);
            transaction.commit();
            return true;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.end();
        }
    }

    @Override
    public List<Order> findActiveOrderByStatus(OrderStatus status, boolean active) throws ServiceException {
        OrderDao orderDao = daoFactory.getOrderDao();
        HaircutDao haircutDao = daoFactory.getHaircutDao();
        BarberDao barberDao = daoFactory.getBarberDao();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        try {
            transaction.initTransaction(
                    (AbstractDao) orderDao,
                    (AbstractDao) haircutDao,
                    (AbstractDao) barberDao,
                    (AbstractDao) userDao,
                    (AbstractDao) userInfoDao);
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
            transaction.commit();
            return orders;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }
}
