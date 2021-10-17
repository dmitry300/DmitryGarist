package by.training.barbershop.dao;

import by.training.barbershop.bean.Entity;
import by.training.barbershop.dao.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T extends Entity> {
    List<T> findAll() throws DaoException;

    T findEntityById(Integer id) throws DaoException;

    boolean delete(T t) throws DaoException;

    boolean delete(Integer id) throws DaoException;

    int create(T t) throws DaoException, SQLException;

    T update(T t) throws DaoException;
}
