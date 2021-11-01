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
    private static final String SQL_INSERT_INTO_HAIRCUTS = "INSERT INTO haircuts(name,time,price)" +
            "VALUES(?,?,?)";

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
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_HAIRCUT_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Haircut haircut = null;
            if (resultSet.next()) {
                haircut = new Haircut();
                haircut.setId(id);
                haircut.setName(resultSet.getString("name"));
                haircut.setTime(resultSet.getTime("time"));
                haircut.setPrice(resultSet.getDouble("price"));
            }
            return haircut;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }

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
        ResultSet resultSet = null;
        int id = 0;
        try {
            statement = connection.prepareStatement(SQL_INSERT_INTO_HAIRCUTS, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, haircut.getName());
            statement.setTime(2, haircut.getTime());
            statement.setDouble(3, haircut.getPrice());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
    }

    @Override
    public Haircut update(Haircut haircut) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_HAIRCUT_BY_ID);
            statement.setString(1, haircut.getName());
            statement.setTime(2, haircut.getTime());
            statement.setDouble(3, haircut.getPrice());
            statement.setInt(4, haircut.getId());
            statement.executeUpdate();
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
