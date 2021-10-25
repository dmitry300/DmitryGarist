package by.training.barbershop.dao;

import by.training.barbershop.bean.Order;
import by.training.barbershop.dao.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> findAll() throws DaoException;

    Order findEntityById(Integer id) throws DaoException;

    List<Order> findEntityByUserId(Integer userId) throws DaoException;

    boolean delete(Order t) throws DaoException;

    boolean delete(Integer id) throws DaoException;

    int create(Order t) throws DaoException, SQLException;

    Order update(Order t) throws DaoException;
}