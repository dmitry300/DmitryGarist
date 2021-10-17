package by.training.barbershop.dao;

import by.training.barbershop.bean.UserInfo;
import by.training.barbershop.dao.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface UserInfoDao extends Dao<UserInfo>{
    List<UserInfo> findAll() throws DaoException;

    UserInfo findEntityById(Integer id) throws DaoException;

    boolean delete(UserInfo t) throws DaoException;

    boolean delete(Integer id) throws DaoException;

    int create(UserInfo t) throws DaoException, SQLException;

    UserInfo update(UserInfo t) throws DaoException;
}
