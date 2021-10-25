package by.training.barbershop.dao.impl;

import by.training.barbershop.dao.TransactionDao;
import by.training.barbershop.dao.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionDaoImpl implements TransactionDao {
    private Connection connection;

    public void initTransaction(AbstractDao dao, AbstractDao... daos) {
        if (connection == null) {
            connection = ConnectionPool.getInstance().getConnection();
        }
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dao.setConnection(connection);
        for (AbstractDao daoElement : daos) {
            daoElement.setConnection(connection);
        }
    }

    public void endTransaction() {
        try {
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void init(AbstractDao dao) {
        if (connection == null) {
            connection = ConnectionPool.getInstance().getConnection();
        }
        dao.setConnection(connection);

    }

    public void end() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
