package by.training.barbershop.controller.impl.client;

import by.training.barbershop.bean.Review;
import by.training.barbershop.bean.User;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.controller.SessionAttribute;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditReviewCommand implements Command {
    private static final Logger logg = LogManager.getLogger(EditReviewCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String contentParameter = request.getParameter("content");
        String reviewIdParameter = request.getParameter("reviewId");
        int reviewId = Integer.parseInt(reviewIdParameter);
        try {
            Review review = serviceFactory.getReviewService().findReviewById(reviewId);
            review.setComment(contentParameter);
            int barberId = review.getBarber().getId();
            if (serviceFactory.getReviewService().updateReview(review)) {
                return new Router(PagePath.REVIEW_BARBER_PAGE_REDIRECT + barberId, Router.RouterType.REDIRECT);
            } else {
                return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
            }
        } catch (ServiceException e) {
            logg.error(e.getMessage());
            return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.REDIRECT);
        }
    }
}
