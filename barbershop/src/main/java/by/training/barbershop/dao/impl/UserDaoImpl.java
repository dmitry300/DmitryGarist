package by.training.barbershop.dao.impl;

import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserInfo;
import by.training.barbershop.bean.UserRole;
import by.training.barbershop.bean.UserStatus;
import by.training.barbershop.dao.UserDao;
import by.training.barbershop.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDao {
    private static final Logger logg = LogManager.getLogger(UserDaoImpl.class);
    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT id, role,password,user_status FROM users" +
            " WHERE login = ?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT id,login," +
            "password,role,user_status FROM users";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT login," +
            "password,role,user_status FROM users WHERE id = ?";
    private static final String SQL_DELETE_USER_BY_ID = "DELETE FROM users" +
            " WHERE id = ?";
    private static final String SQL_UPDATE_USER_BY_ID = "UPDATE users" +
            " SET login = ?, password= ?, role= ?, user_status = ? WHERE  id = ?";
    private static final String SQL_INSERT_INTO_USER = "INSERT INTO" +
            " users(login,password,role,user_status)VALUES(?,?,?,?)";

    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_USERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                UserInfo userInfo = new UserInfo();
                userInfo.setId(user.getId());
                user.setUserInfo(userInfo);
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(UserRole.getById(resultSet.getInt("role")));
                user.setUserStatus(UserStatus.getById(resultSet.getInt("user_status")));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
    }

    public User findUserByLogin(String login) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(login);
                user.setRole(UserRole.getById(resultSet.getInt("role")));
                user.setPassword(resultSet.getString("password"));
                user.setUserStatus(UserStatus.getById(resultSet.getInt("user_status")));
            }
            return user;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
    }

    @Override
    public User findEntityById(Integer id) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(UserRole.getById(resultSet.getInt("role")));
                user.setUserStatus(UserStatus.getById(resultSet.getInt("user_status")));
            }
            return user;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
    }

    @Override
    public boolean delete(User user) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_USER_BY_ID);
            statement.setInt(1, user.getId());
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On delete modify more then 1 record: " + count);
            }
            return true;
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
            statement = connection.prepareStatement(SQL_DELETE_USER_BY_ID);
            statement.setInt(1, id);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On delete modify more then 1 record: " + count);
            }
            return true;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public int create(User user) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int id = 0;
        try {
            statement = connection.prepareStatement(SQL_INSERT_INTO_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getId());
            statement.setInt(4, user.getUserStatus().getId());
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
    public User update(User user) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_USER_BY_ID);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getId());
            statement.setInt(4, user.getUserStatus().getId());
            statement.setInt(5, user.getId());
            int rowsUpdate = statement.executeUpdate();
            logg.info("Updated: {} rows", rowsUpdate);
            return user;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }
}
