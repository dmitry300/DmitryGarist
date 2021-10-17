package by.training.barbershop.dao;

import by.training.barbershop.bean.Review;
import by.training.barbershop.dao.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface ReviewDao extends Dao<Review>{
    List<Review> findAll() throws DaoException;

    Review findEntityById(Integer id) throws DaoException;

    boolean delete(Review t) throws DaoException;

    boolean delete(Integer id) throws DaoException;

    int create(Review t) throws DaoException, SQLException;

    Review update(Review t) throws DaoException;
}
