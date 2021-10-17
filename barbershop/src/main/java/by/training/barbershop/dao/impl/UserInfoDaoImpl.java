package by.training.barbershop.dao.impl;

import by.training.barbershop.bean.User;

import by.training.barbershop.bean.UserInfo;
import by.training.barbershop.dao.UserInfoDao;
import by.training.barbershop.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDaoImpl extends AbstractDao implements UserInfoDao {
    private static final Logger logg = LogManager.getLogger(UserInfoDaoImpl.class);
    private static final String SQL_SELECT_ALL_USER_INFO = "SELECT id,name," +
            "surname,patronymic,phone,birthday,email FROM user_info";
    private static final String SQL_SELECT_USER_BY_SURNAME = "SELECT id,name," +
            "patronymic,phone,birthday,email FROM user_info WHERE surname = ?";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT id,name," +
            "patronymic,phone,birthday,email FROM user_info WHERE id = ?";
    private static final String SQL_DELETE_USER_INFO_BY_ID = "DELETE FROM user_info" +
            " WHERE id = ?";
    private static final String SQL_UPDATE_USER_INFO_BY_ID = "UPDATE user_info" +
            " set name = ?,surname= ?,patronymic= ?,phone= ?,birthday= ?,email= ? WHERE  id = ?";
    private static final String SQL_INSERT_INTO_USER_INFO = "INSERT INTO" +
            " user_info(id,name,surname,patronymic,phone,birthday,email)" +
            "VALUES(?,?,?,?,?,?,?)";

    public List<UserInfo> findUserBySurname(String surname) throws DaoException {
        List<UserInfo> userInfos = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_SURNAME);
            statement.setString(1, surname);
            finding(userInfos, statement);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
        return userInfos;
    }

    private void finding(List<UserInfo> userInfos, PreparedStatement statement) throws SQLException, DaoException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            UserInfo userInfo = new UserInfo();
            User user = new User();
            int id = (resultSet.getInt("id"));
            user.setId(id);
            userInfo.setUser(user);
            userInfo.setPhone(resultSet.getLong("phone"));
            userInfo.setName(resultSet.getString("name"));
            userInfo.setBirthday(resultSet.getDate("birthday"));
            userInfo.setPatronymic(resultSet.getString("patronymic"));
            userInfo.setEmail(resultSet.getString("email"));
            userInfo.setSurname(resultSet.getString("surname"));
            userInfos.add(userInfo);
        }
        closeResultSet(resultSet);
    }

    @Override
    public List<UserInfo> findAll() throws DaoException {
        List<UserInfo> userInfos = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_USER_INFO);
            finding(userInfos, statement);
            return userInfos;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public UserInfo findEntityById(Integer id) throws DaoException {
        UserInfo userInfo = new UserInfo();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(id);
                userInfo.setUser(user);
                userInfo.setPhone(resultSet.getLong("phone"));
                userInfo.setName(resultSet.getString("name"));
                userInfo.setBirthday(resultSet.getDate("birthday"));
                userInfo.setPatronymic(resultSet.getString("patronymic"));
                userInfo.setEmail(resultSet.getString("email"));
                userInfo.setSurname(resultSet.getString("surname"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return userInfo;
    }

    @Override
    public boolean delete(UserInfo userInfo) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_USER_INFO_BY_ID);
            statement.setInt(1, userInfo.getId());
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
            statement = connection.prepareStatement(SQL_DELETE_USER_INFO_BY_ID);
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
    public int create(UserInfo userInfo) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_INTO_USER_INFO);
            statement.setInt(1, userInfo.getUser().getId());
            statement.setString(2, userInfo.getName());
            statement.setString(3, userInfo.getSurname());
            statement.setString(4, userInfo.getPatronymic());
            statement.setLong(5, userInfo.getPhone());
            statement.setDate(6, userInfo.getBirthday());
            statement.setString(7, userInfo.getEmail());
            statement.executeUpdate();
            return userInfo.getUser().getId();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public UserInfo update(UserInfo userInfo) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_USER_INFO_BY_ID);
            statement.setInt(1, userInfo.getId());
            statement.setString(2, userInfo.getName());
            statement.setString(3, userInfo.getSurname());
            statement.setString(4, userInfo.getPatronymic());
            statement.setLong(5, userInfo.getPhone());
            statement.setDate(6, userInfo.getBirthday());
            statement.setString(7, userInfo.getEmail());
            int rowsUpdate = statement.executeUpdate();
            logg.info("Updated: {} rows", rowsUpdate);
            return userInfo;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }
}
