package by.training.barbershop.dao.impl;

import by.training.barbershop.dao.exception.DaoException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao {
    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void closeStatement(Statement statement) throws DaoException {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void closeResultSet(ResultSet resultSet) throws DaoException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
