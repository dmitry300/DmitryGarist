package by.training.barbershop.dao.impl;

import by.training.barbershop.bean.*;
import by.training.barbershop.dao.OrderDao;
import by.training.barbershop.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDaoImpl extends AbstractDao implements OrderDao {
    private static final Logger logg = LogManager.getLogger(OrdersDaoImpl.class);
    private static final String SQL_SELECT_ALL_ORDERS = "SELECT id, status, date_time, date_time_plane, user_id," +
            " barber_id, haircut_id FROM orders ORDER BY date_time_plane";
    private static final String SQL_SELECT_ORDER_BY_ID = "SELECT user_id,status,date_time," +
            "date_time_plane,barber_id,haircut_id FROM orders WHERE id = ?";
    private static final String SQL_SELECT_ORDER_BY_STATUS = "SELECT id, user_id, date_time, " +
            "date_time_plane, barber_id, haircut_id FROM orders WHERE status = ? ORDER BY date_time_plane";
    private static final String SQL_SELECT_ORDER_BY_USER_ID = "SELECT id,status,date_time," +
            "date_time_plane,barber_id,haircut_id FROM orders WHERE user_id = ? ORDER BY date_time_plane";
    private static final String SQL_DELETE_ORDER_BY_ID = "DELETE FROM orders WHERE id = ?";
    private static final String SQL_UPDATE_ORDER_BY_ID = "UPDATE orders SET status = ?, " +
            "date_time = ?, date_time_plane = ?, user_id = ?, barber_id = ?, haircut_id = ? WHERE  id = ?";
    private static final String SQL_INSERT_INTO_ORDERS = "INSERT INTO " +
            "orders(status,date_time,date_time_plane,user_id,barber_id,haircut_id) VALUES(?,?,?,?,?,?)";

    @Override
    public List<Order> findAll() throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_ORDERS);
            resultSet = statement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setStatus(OrderStatus.getById(resultSet.getInt("status")));
                order.setDateTime(resultSet.getTimestamp("date_time"));
                order.setDateTimePlane(resultSet.getTimestamp("date_time_plane"));
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                order.setUser(user);
                Barber barber = new Barber();
                barber.setId(resultSet.getInt("barber_id"));
                order.setBarber(barber);
                Haircut haircut = new Haircut();
                haircut.setId(resultSet.getInt("haircut_id"));
                order.setHaircut(haircut);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
    }

    @Override
    public List<Order> findEntityByUserId(Integer userId) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ORDER_BY_USER_ID);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setStatus(OrderStatus.getById(resultSet.getInt("status")));
                order.setDateTime(resultSet.getTimestamp("date_time"));
                order.setDateTimePlane(resultSet.getTimestamp("date_time_plane"));
                User user = new User();
                user.setId(userId);
                order.setUser(user);
                Barber barber = new Barber();
                barber.setId(resultSet.getInt("barber_id"));
                order.setBarber(barber);
                Haircut haircut = new Haircut();
                haircut.setId(resultSet.getInt("haircut_id"));
                order.setHaircut(haircut);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
    }

    @Override
    public List<Order> findEntityByStatus(OrderStatus status) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ORDER_BY_STATUS);
            statement.setInt(1, status.getId());
            resultSet = statement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setStatus(status);
                order.setDateTime(resultSet.getTimestamp("date_time"));
                order.setDateTimePlane(resultSet.getTimestamp("date_time_plane"));
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                order.setUser(user);
                Barber barber = new Barber();
                barber.setId(resultSet.getInt("barber_id"));
                order.setBarber(barber);
                Haircut haircut = new Haircut();
                haircut.setId(resultSet.getInt("haircut_id"));
                order.setHaircut(haircut);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
    }

    @Override
    public Order findEntityById(Integer id) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ORDER_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Order order = null;
            if (resultSet.next()) {
                order = new Order();
                order.setId(id);
                order.setStatus(OrderStatus.getById(resultSet.getInt("status")));
                order.setDateTimePlane(resultSet.getTimestamp("date_time_plane"));
                order.setDateTime(resultSet.getTimestamp("date_time"));
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                order.setUser(user);
                Barber barber = new Barber();
                barber.setId(resultSet.getInt("barber_id"));
                order.setBarber(barber);
                Haircut haircut = new Haircut();
                haircut.setId(resultSet.getInt("haircut_id"));
                order.setHaircut(haircut);
            }
            return order;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
    }

    @Override
    public boolean delete(Order order) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ORDER_BY_ID);
            statement.setInt(1, order.getId());
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On delete modify more then 1 record: " + count);
            } else {
                return true;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_ORDER_BY_ID);
            statement.setInt(1, id);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On delete modify more then 1 record: " + count);
            } else {
                return true;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public int create(Order order) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int id = 0;
        try {
            statement = connection.prepareStatement(SQL_INSERT_INTO_ORDERS, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getStatus().getId());
            statement.setTimestamp(2, order.getDateTime());
            statement.setTimestamp(3, order.getDateTimePlane());
            statement.setInt(4, order.getUser().getId());
            statement.setInt(5, order.getBarber().getId());
            statement.setInt(6, order.getHaircut().getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
    }

    @Override
    public Order update(Order order) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_ORDER_BY_ID);
            statement.setInt(1, order.getStatus().getId());
            statement.setTimestamp(2, order.getDateTime());
            statement.setTimestamp(3, order.getDateTimePlane());
            statement.setInt(4, order.getUser().getId());
            statement.setInt(5, order.getBarber().getId());
            statement.setInt(6, order.getHaircut().getId());
            statement.setInt(7, order.getId());
            int rowsUpdate = statement.executeUpdate();
            logg.info("Updated: {} rows", rowsUpdate);
            return order;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }
}
