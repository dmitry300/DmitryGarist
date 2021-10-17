package by.training.barbershop.dao;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.dao.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface BarberDao extends Dao<Barber> {
    List<Barber> findAll() throws DaoException;

    Barber findEntityById(Integer id) throws DaoException;

    boolean delete(Barber t) throws DaoException;

    boolean delete(Integer id) throws DaoException;

    int create(Barber t) throws DaoException, SQLException;

    Barber update(Barber t) throws DaoException;
}
