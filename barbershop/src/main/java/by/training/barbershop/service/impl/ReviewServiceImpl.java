package by.training.barbershop.service.impl;

import by.training.barbershop.bean.Review;
import by.training.barbershop.dao.ReviewDao;
import by.training.barbershop.dao.exception.DaoException;
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
        try {
            return reviewDao.findEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public int addReview(Review review) throws ServiceException {
        LocalDateTime dateTime = LocalDateTime.now();
        review.setCommentData(Timestamp.valueOf(dateTime));
        ReviewDao reviewDao = daoFactory.getReviewDao();
        try {
            return reviewDao.create(review);
        } catch (DaoException | SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
