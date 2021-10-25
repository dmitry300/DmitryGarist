package by.training.barbershop.dao;

import by.training.barbershop.bean.User;
import by.training.barbershop.dao.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends Dao<User> {
    List<User> findAll() throws DaoException;

    User findEntityById(Integer id) throws DaoException;

    boolean delete(User t) throws DaoException;

    boolean delete(Integer id) throws DaoException;

    int create(User t) throws DaoException, SQLException;

    User update(User t) throws DaoException;

    User findUserByLogin(String login) throws DaoException;
}
