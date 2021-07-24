package by.training.task06.dao;

import by.training.task06.dao.exception.DaoException;
import by.training.task06.bean.ThreadBean;

import java.util.List;

public interface ThreadDao {
    List<ThreadBean> saveThreadNumber(String filename) throws DaoException;
}
