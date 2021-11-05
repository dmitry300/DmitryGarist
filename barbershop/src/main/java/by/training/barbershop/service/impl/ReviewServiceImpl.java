package by.training.barbershop.service.impl;

import by.training.barbershop.bean.Review;
import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserInfo;
import by.training.barbershop.dao.*;
import by.training.barbershop.dao.exception.DaoException;
import by.training.barbershop.dao.exception.DatabaseConnectionException;
import by.training.barbershop.dao.impl.AbstractDao;
import by.training.barbershop.dao.impl.DaoFactory;
import by.training.barbershop.service.ReviewService;
import by.training.barbershop.service.exception.ServiceException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private final Transaction transaction = daoFactory.getTransactionDao();

    @Override
    public Review findReviewById(int id) throws ServiceException {
        ReviewDao reviewDao = daoFactory.getReviewDao();
        try {
            transaction.initTransaction((AbstractDao) reviewDao);
            return reviewDao.findEntityById(id);
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public void addReview(Review review) throws ServiceException {
        LocalDateTime dateTime = LocalDateTime.now();
        review.setCommentData(Timestamp.valueOf(dateTime));
        ReviewDao reviewDao = daoFactory.getReviewDao();
        try {
            transaction.initTransaction((AbstractDao) reviewDao);
            reviewDao.create(review);
        } catch (DaoException | SQLException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean removeReview(int reviewId) throws ServiceException {
        ReviewDao reviewDao = daoFactory.getReviewDao();
        try {
            transaction.initTransaction((AbstractDao) reviewDao);
            return reviewDao.delete(reviewId);
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean updateReview(Review review) throws ServiceException {
        LocalDateTime dateTime = LocalDateTime.now();
        review.setCommentData(Timestamp.valueOf(dateTime));
        ReviewDao reviewDao = daoFactory.getReviewDao();
        try {
            transaction.initTransaction((AbstractDao) reviewDao);
            reviewDao.update(review);
            transaction.commit();
            return true;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public List<Review> findReviewsByBarberId(int barberId) throws ServiceException {
        ReviewDao reviewDao = daoFactory.getReviewDao();
        BarberDao barberDao = daoFactory.getBarberDao();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        try {
            transaction.initTransaction(
                    (AbstractDao) reviewDao,
                    (AbstractDao) barberDao,
                    (AbstractDao) userDao,
                    (AbstractDao) userInfoDao);
            List<Review> reviews = reviewDao.findReviewByBarberId(barberId);
            for (var review : reviews) {
                review.setBarber(barberDao.findEntityById(review.getBarber().getId()));
                UserInfo userInfo = userInfoDao.findEntityById(review.getUser().getId());
                User user = userDao.findEntityById(review.getUser().getId());
                user.setUserInfo(userInfo);
                review.setUser(user);
            }
            transaction.commit();
            return reviews;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transaction.endTransaction();
        }
    }
}
