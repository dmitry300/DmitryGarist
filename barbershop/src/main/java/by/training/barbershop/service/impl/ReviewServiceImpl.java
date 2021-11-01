package by.training.barbershop.service.impl;

import by.training.barbershop.bean.Review;
import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserInfo;
import by.training.barbershop.dao.*;
import by.training.barbershop.dao.exception.DaoException;
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

    @Override
    public List<Review> findAllReviews() throws ServiceException {
        ReviewDao reviewDao = daoFactory.getReviewDao();
        try {
            return reviewDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Review findReviewById(int id) throws ServiceException {
        ReviewDao reviewDao = daoFactory.getReviewDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) reviewDao);
        try {
            return reviewDao.findEntityById(id);
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transactionDao.endTransaction();
        }
    }

    @Override
    public void addReview(Review review) throws ServiceException {
        LocalDateTime dateTime = LocalDateTime.now();
        review.setCommentData(Timestamp.valueOf(dateTime));
        ReviewDao reviewDao = daoFactory.getReviewDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) reviewDao);
        try {
            reviewDao.create(review);
        } catch (DaoException | SQLException e) {
            transactionDao.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transactionDao.endTransaction();
        }
    }

    @Override
    public boolean removeReview(int reviewId) throws ServiceException {
        ReviewDao reviewDao = daoFactory.getReviewDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) reviewDao);
        try {
            return reviewDao.delete(reviewId);
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transactionDao.endTransaction();
        }
    }

    @Override
    public boolean updateReview(Review review) throws ServiceException {
        LocalDateTime dateTime = LocalDateTime.now();
        review.setCommentData(Timestamp.valueOf(dateTime));
        ReviewDao reviewDao = daoFactory.getReviewDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) reviewDao);
        try {
            reviewDao.update(review);
            transactionDao.commit();
            return true;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transactionDao.endTransaction();
        }
    }

    @Override
    public List<Review> findReviewsByBarberId(int barberId) throws ServiceException {
        ReviewDao reviewDao = daoFactory.getReviewDao();
        BarberDao barberDao = daoFactory.getBarberDao();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction(
                (AbstractDao) reviewDao,
                (AbstractDao) barberDao,
                (AbstractDao) userDao,
                (AbstractDao) userInfoDao);
        try {
            List<Review> reviews = reviewDao.findReviewByBarberId(barberId);
            for (var review : reviews) {
                review.setBarber(barberDao.findEntityById(review.getBarber().getId()));
                UserInfo userInfo = userInfoDao.findEntityById(review.getUser().getId());
                User user = userDao.findEntityById(review.getUser().getId());
                user.setUserInfo(userInfo);
                review.setUser(user);
            }
            transactionDao.commit();
            return reviews;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transactionDao.endTransaction();
        }
    }
}
