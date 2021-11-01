package by.training.barbershop.dao.impl;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.bean.Review;
import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserInfo;
import by.training.barbershop.dao.ReviewDao;
import by.training.barbershop.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewDaoImpl extends AbstractDao implements ReviewDao {
    private static final Logger logg = LogManager.getLogger(ReviewDaoImpl.class);
    private static final String SQL_SELECT_ALL_REVIEWS = "SELECT id,comment,comment_data,user_id,barber_id FROM reviews";
    private static final String SQL_SELECT_REVIEW_BY_ID = "SELECT comment,comment_data,user_id,barber_id FROM reviews WHERE id = ?";
    private static final String SQL_SELECT_REVIEW_BY_BARBER_ID = "SELECT comment,comment_data,user_id,id FROM reviews WHERE barber_id = ?";
    private static final String SQL_DELETE_REVIEW_BY_ID = "DELETE FROM reviews WHERE id = ?";
    private static final String SQL_UPDATE_REVIEW_BY_ID = "UPDATE reviews set comment =?,comment_data=?,user_id=?,barber_id=? WHERE  id = ?";
    private static final String SQL_INSERT_INTO_REVIEW = "INSERT INTO reviews(comment,comment_data,user_id,barber_id)" +
            "VALUES(?,?,?,?)";

    @Override
    public List<Review> findAll() throws DaoException {
        List<Review> reviews = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_REVIEWS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                Barber barber = new Barber();
                Review review = new Review();
                review.setId(resultSet.getInt("id"));
                review.setComment(resultSet.getString("comment"));
                review.setCommentData(resultSet.getTimestamp("comment_data"));
                barber.setId(resultSet.getInt("barber_id"));
                user.setId(resultSet.getInt("user_id"));
                review.setBarber(barber);
                review.setUser(user);
                reviews.add(review);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return reviews;
    }

    @Override
    public List<Review> findReviewByBarberId(int barberId) throws DaoException {
        List<Review> reviews = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_REVIEW_BY_BARBER_ID);
            statement.setInt(1, barberId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                UserInfo userInfo = new UserInfo();
                Barber barber = new Barber();
                Review review = new Review();
                review.setId(resultSet.getInt("id"));
                review.setComment(resultSet.getString("comment"));
                review.setCommentData(resultSet.getTimestamp("comment_data"));
                barber.setId(barberId);
                user.setId(resultSet.getInt("user_id"));
                userInfo.setId(user.getId());
                user.setUserInfo(userInfo);
                review.setBarber(barber);
                review.setUser(user);
                reviews.add(review);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return reviews;
    }

    @Override
    public Review findEntityById(Integer id) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_REVIEW_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Review review = null;
            if (resultSet.next()) {
                review = new Review();
                User user = new User();
                Barber barber = new Barber();
                UserInfo userInfo = new UserInfo();
                review.setId(id);
                review.setComment(resultSet.getString("comment"));
                review.setCommentData(resultSet.getTimestamp("comment_data"));
                barber.setId(resultSet.getInt("barber_id"));
                user.setId(resultSet.getInt("user_id"));
                userInfo.setId(user.getId());
                user.setUserInfo(userInfo);
                review.setBarber(barber);
                review.setUser(user);
            }
            return review;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
    }

    @Override
    public boolean delete(Review review) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_REVIEW_BY_ID);
            statement.setInt(1, review.getId());
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
            statement = connection.prepareStatement(SQL_DELETE_REVIEW_BY_ID);
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
    public int create(Review review) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int id = 0;
        try {
            statement = connection.prepareStatement(SQL_INSERT_INTO_REVIEW, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, review.getComment());
            statement.setTimestamp(2, review.getCommentData());
            statement.setInt(3, review.getUser().getId());
            statement.setInt(4, review.getBarber().getId());
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
    public Review update(Review review) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_REVIEW_BY_ID);
            statement.setString(1, review.getComment());
            statement.setTimestamp(2, review.getCommentData());
            statement.setInt(3, review.getUser().getId());
            statement.setInt(4, review.getBarber().getId());
            statement.setInt(5, review.getId());
            int rowsUpdate = statement.executeUpdate();
            logg.info("Updated: {} rows", rowsUpdate);
            return review;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeStatement(statement);
        }
    }
}
