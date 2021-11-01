package by.training.barbershop.controller.impl.client;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.bean.Review;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.controller.impl.admin.GoToEditBarberCommand;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class GoToEditReviewCommand implements Command {
    private static final Logger logg = LogManager.getLogger(GoToEditReviewCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String reviewIdParameter = request.getParameter("reviewId");

        try {
            Review review = serviceFactory.getReviewService().findReviewById(Integer.parseInt(reviewIdParameter));
            Barber barber = serviceFactory.getBarberService().findBarberById(review.getBarber().getId());
            if (barber == null) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.REDIRECT);
            }
            request.setAttribute("review", review);
            request.setAttribute("barber", barber);
        } catch (ServiceException e) {
            logg.error(e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }
        return new Router(PagePath.EDIT_REVIEW_PAGE, Router.RouterType.FORWARD);
    }
}
