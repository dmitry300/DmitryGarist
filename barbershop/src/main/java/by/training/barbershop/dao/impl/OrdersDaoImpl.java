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
    private static final String SQL_SELECT_ALL_ORDERS = "SELECT id,date_time, user_info_id," +
            " barber_id, haircut_id FROM orders";
    private static final String SQL_SELECT_ORDER_BY_ID = "SELECT user_info_id,date_time," +
            "barber_id,haircut_id FROM orders WHERE id = ?";
    private static final String SQL_SELECT_ORDER_BY_USER_INFO_ID = "SELECT id,date_time," +
            "barber_id,haircut_id FROM orders WHERE user_info_id = ?";
    private static final String SQL_DELETE_ORDER_BY_ID = "DELETE FROM orders WHERE id = ?";
    private static final String SQL_UPDATE_ORDER_BY_ID = "UPDATE orders set user_info_id = ?," +
            " date_time = ?," +
            "barber_id = ?,haircut_id = ? WHERE  id = ?";
    private static final String SQL_INSERT_INTO_ORDERS = "INSERT INTO " +
            "orders(id,date_time,user_info_id,barber_id,haircut_id) VALUES(?,?,?,?,?)";

    private void finding(List<Order> orders, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setDateTime(resultSet.getTimestamp("date_time"));
            UserInfo userInfo = new UserInfo();
            User user = new User();
            user.setId(resultSet.getInt("user_info_id"));
            userInfo.setUser(user);
            order.setUserInfo(userInfo);
            Barber barber = new Barber();
            barber.setId(resultSet.getInt("barber_id"));
            order.setBarber(barber);
            Haircut haircut = new Haircut();
            haircut.setId(resultSet.getInt("haircut_id"));
            order.setHaircut(haircut);
            orders.add(order);
        }
    }

    @Override
    public List<Order> findAll() throws DaoException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_ORDERS);
            finding(orders, statement);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
        return orders;
    }

    public Order findEntityByUserInfoId(Integer id) throws DaoException {
        Order order = new Order();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ORDER_BY_USER_INFO_ID);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(id);
                UserInfo userInfo = new UserInfo();
                userInfo.setUser(user);
                order.setId(resultSet.getInt("id"));
                order.setDateTime(resultSet.getTimestamp("date_time"));
                Barber barber = new Barber();
                resultSet.getInt("barber_id");
                order.setBarber(barber);
                Haircut haircut = new Haircut();
                resultSet.getInt("haircut_id");
                order.setHaircut(haircut);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return order;
    }

    @Override
    public Order findEntityById(Integer id) throws DaoException {
        Order order = new Order();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ORDER_BY_ID);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                order.setId(resultSet.getInt("id"));
                User user = new User();
                user.setId(id);
                UserInfo userInfo = new UserInfo();
                userInfo.setUser(user);
                order.setDateTime(resultSet.getTimestamp("date_time"));
                Barber barber = new Barber();
                resultSet.getInt("barber_id");
                order.setBarber(barber);
                Haircut haircut = new Haircut();
                resultSet.getInt("haircut_id");
                order.setHaircut(haircut);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return order;
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
        try {
            statement = connection.prepareStatement(SQL_INSERT_INTO_ORDERS, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getId());
            statement.setTimestamp(2, order.getDateTime());
            statement.setInt(3, order.getUserInfo().getId());
            statement.setInt(4, order.getBarber().getId());
            statement.setInt(5, order.getHaircut().getId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public Order update(Order order) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_ORDER_BY_ID);
            statement.setInt(1, order.getId());
            statement.setTimestamp(2, order.getDateTime());
            statement.setInt(3, order.getUserInfo().getId());
            statement.setInt(4, order.getBarber().getId());
            statement.setInt(5, order.getHaircut().getId());
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
