package by.training.barbershop.dao.impl;

import by.training.barbershop.bean.Haircut;
import by.training.barbershop.dao.HaircutDao;
import by.training.barbershop.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HaircutDaoImpl extends AbstractDao implements HaircutDao {
    private static final Logger logg = LogManager.getLogger(HaircutDaoImpl.class);
    private static final String SQL_SELECT_ALL_HAIRCUTS = "SELECT id,name,time,price FROM haircuts";
    private static final String SQL_SELECT_HAIRCUT_BY_ID = "SELECT name,time,price FROM haircuts WHERE id = ?";
    private static final String SQL_DELETE_HAIRCUT_BY_ID = "DELETE FROM haircuts WHERE id = ?";
    private static final String SQL_UPDATE_HAIRCUT_BY_ID = "UPDATE haircuts set name = ?, time = ?, price = ? WHERE  id = ?";
    private static final String SQL_INSERT_INTO_HAIRCUTS = "INSERT INTO haircuts(id,name,time,price)" +
            "VALUES(?,?,?,?)";

    private void finding(List<Haircut> haircuts, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Haircut haircut = new Haircut();
            haircut.setId(resultSet.getInt("id"));
            haircut.setName(resultSet.getString("name"));
            haircut.setTime(resultSet.getTime("time"));
            haircut.setPrice(resultSet.getDouble("price"));
            haircuts.add(haircut);
        }
    }

    private void haircutSetStatement(Haircut haircut, PreparedStatement statement) throws SQLException {
        statement.setInt(1, haircut.getId());
        statement.setString(2, haircut.getName());
        statement.setTime(2, haircut.getTime());
        statement.setDouble(4, haircut.getPrice());
        statement.executeUpdate();
    }

    @Override
    public List<Haircut> findAll() throws DaoException {
        List<Haircut> haircuts = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_HAIRCUTS);
            finding(haircuts, statement);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
        return haircuts;
    }

    @Override
    public Haircut findEntityById(Integer id) throws DaoException {
        Haircut haircut = new Haircut();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_HAIRCUT_BY_ID);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                haircut.setId(resultSet.getInt("id"));
                haircut.setName(resultSet.getString("name"));
                haircut.setTime(resultSet.getTime("time"));
                haircut.setPrice(resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return haircut;
    }

    @Override
    public boolean delete(Haircut haircut) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_HAIRCUT_BY_ID);
            statement.setInt(1, haircut.getId());
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On delete modify more then 1 record: " + count);
            } else {
                return true;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_HAIRCUT_BY_ID);
            statement.setInt(1, id);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On delete modify more then 1 record: " + count);
            } else {
                return true;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public int create(Haircut haircut) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_INTO_HAIRCUTS, Statement.RETURN_GENERATED_KEYS);
            haircutSetStatement(haircut, statement);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public Haircut update(Haircut haircut) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_HAIRCUT_BY_ID);
            haircutSetStatement(haircut, statement);
            int rowsUpdate = statement.executeUpdate();
            logg.info("Updated: {} rows", rowsUpdate);
            return haircut;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }
}
