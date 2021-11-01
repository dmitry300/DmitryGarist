package by.training.barbershop.controller.impl.admin;

import by.training.barbershop.bean.Review;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RemoveReviewCommand implements Command {
    private static final Logger logg = LogManager.getLogger(RemoveReviewCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String reviewIdParameter = request.getParameter("reviewId");
        int reviewId = Integer.parseInt(reviewIdParameter);
        try {
            Review review = serviceFactory.getReviewService().findReviewById(reviewId);
            int barberId = review.getBarber().getId();

            if (!serviceFactory.getReviewService().removeReview(reviewId)) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }

            return new Router(PagePath.REVIEW_BARBER_PAGE_REDIRECT + barberId, Router.RouterType.REDIRECT);
        } catch (ServiceException e) {
            logg.error("Service exception: {}", e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
    }
}
