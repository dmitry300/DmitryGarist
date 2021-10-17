package by.training.barbershop.dao;

import by.training.barbershop.bean.Haircut;
import by.training.barbershop.dao.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface HaircutDao extends Dao<Haircut>{
    List<Haircut> findAll() throws DaoException;

    Haircut findEntityById(Integer id) throws DaoException;

    boolean delete(Haircut t) throws DaoException;

    boolean delete(Integer id) throws DaoException;

    int create(Haircut t) throws DaoException, SQLException;

    Haircut update(Haircut t) throws DaoException;
}
