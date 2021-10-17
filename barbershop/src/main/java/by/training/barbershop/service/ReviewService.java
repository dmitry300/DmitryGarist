package by.training.barbershop.service;

import by.training.barbershop.bean.Review;
import by.training.barbershop.service.exception.ServiceException;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews() throws ServiceException;

    Review findReviewById(int id) throws ServiceException;

    int addReview(Review review) throws ServiceException;
}
