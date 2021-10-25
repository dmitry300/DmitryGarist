package by.training.barbershop.dao.impl;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.dao.BarberDao;
import by.training.barbershop.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BarbersDaoImpl extends AbstractDao implements BarberDao {
    private static final Logger logg = LogManager.getLogger(BarbersDaoImpl.class);
    private static final String SQL_SELECT_ALL_BARBERS = "SELECT id, name, surname," +
            " patronymic, age, photo, phone, start_job, tiktok_link, end_job FROM barbers";
    private static final String SQL_SELECT_BARBER_BY_SURNAME = "SELECT id, name," +
            " patronymic, age, photo, phone, start_job, tiktok_link, end_job FROM barbers WHERE surname = ?";
    private static final String SQL_SELECT_BARBER_BY_ID = "SELECT name,surname," +
            " patronymic, age, photo, phone, start_job, tiktok_link, end_job FROM barbers WHERE id = ?";
    private static final String SQL_DELETE_BARBER_BY_ID = "DELETE FROM barbers" +
            " WHERE id = ?";
    private static final String SQL_UPDATE_BARBER_BY_ID = "UPDATE barbers set name = ?," +
            "surname= ?,patronymic= ?,age= ?,photo=?,phone= ?,start_job= ?, end_job=?,tiktok_link=? WHERE  id = ?";
    private static final String SQL_INSERT_INTO_BARBERS = "INSERT INTO" +
            " barbers(name, surname, patronymic, age, photo, phone, start_job, tiktok_link, end_job)" +
            "VALUES(?,?,?,?,?,?,?,?,?)";

    private void finding(List<Barber> barbers, PreparedStatement statement) throws SQLException, DaoException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Barber barber = new Barber();
            barber.setId(resultSet.getInt("id"));
            barber.setName(resultSet.getString("name"));
            barber.setSurname(resultSet.getString("surname"));
            barber.setPatronymic(resultSet.getString("patronymic"));
            barber.setAge(resultSet.getInt("age"));
            barber.setPhoto(resultSet.getString("photo"));
            barber.setPhone(resultSet.getLong("phone"));
            // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            barber.setStartJob(resultSet.getDate("start_job"));
            barber.setEndJob(resultSet.getDate("end_job"));
            barber.setTiktokLink(resultSet.getString("tiktok_link"));
            barbers.add(barber);
        }
        closeResultSet(resultSet);
    }

    public List<Barber> findUserBySurname(String surname) throws DaoException {
        List<Barber> barbers = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_BARBER_BY_SURNAME);
            statement.setString(1, surname);
            finding(barbers, statement);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
        return barbers;
    }


    @Override
    public List<Barber> findAll() throws DaoException {
        List<Barber> barbers = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_BARBERS);
            finding(barbers, statement);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
        return barbers;
    }

    @Override
    public Barber findEntityById(Integer id) throws DaoException {
        Barber barber = new Barber();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_BARBER_BY_ID);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                barber.setId(id);
                barber.setName(resultSet.getString("name"));
                barber.setSurname(resultSet.getString("surname"));
                barber.setPatronymic(resultSet.getString("patronymic"));
                barber.setAge(resultSet.getInt("age"));
                barber.setPhoto(resultSet.getString("photo"));
                barber.setPhone(resultSet.getLong("phone"));
                // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                barber.setStartJob(resultSet.getDate("start_job"));
                barber.setEndJob(resultSet.getDate("end_job"));
                barber.setTiktokLink(resultSet.getString("tiktok_link"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return barber;
    }

    @Override
    public boolean delete(Barber barber) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_BARBER_BY_ID);
            statement.setInt(1, barber.getId());
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
            statement = connection.prepareStatement(SQL_DELETE_BARBER_BY_ID);
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
    public int create(Barber barber) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_INTO_BARBERS, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, barber.getName());
            statement.setString(2, barber.getSurname());
            statement.setString(3, barber.getPatronymic());
            statement.setInt(4, barber.getAge());
            statement.setString(5, barber.getPhoto());
            statement.setLong(6, barber.getPhone());
            statement.setDate(7, barber.getStartJob());
            statement.setDate(8, barber.getEndJob());
            statement.setString(9, barber.getTiktokLink());
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
    public Barber update(Barber barber) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_BARBER_BY_ID);
            statement.setInt(1, barber.getId());
            statement.setString(2, barber.getName());
            statement.setString(3, barber.getSurname());
            statement.setString(4, barber.getPatronymic());
            statement.setInt(5, barber.getAge());
            statement.setString(6, barber.getPhoto());
            statement.setLong(7, barber.getPhone());
            statement.setDate(8, barber.getStartJob());
            statement.setDate(9, barber.getEndJob());
            statement.setString(10, barber.getTiktokLink());
            statement.executeUpdate();
            int rowsUpdate = statement.executeUpdate();
            logg.info("Updated: {} rows", rowsUpdate);
            return barber;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }

}
