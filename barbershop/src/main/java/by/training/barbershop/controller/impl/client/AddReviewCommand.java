package by.training.barbershop.controller.impl.client;

import by.training.barbershop.bean.Haircut;
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

public class AddReviewCommand implements Command {
    private static final Logger logg = LogManager.getLogger(AddReviewCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String contentParameter = request.getParameter("content");
        String barberIdParameter = request.getParameter("barberId");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.USER);
        int barberId = Integer.parseInt(barberIdParameter);
        try {
            Review review = new Review();
            review.setComment(contentParameter);
            review.setUser(user);
            review.setBarber(serviceFactory.getBarberService().findBarberById(barberId));
            serviceFactory.getReviewService().addReview(review);

        } catch (ServiceException e) {
            logg.error("Service exception: {}", e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
        return new Router(PagePath.REVIEW_BARBER_PAGE_REDIRECT + barberId, Router.RouterType.REDIRECT);
    }
}
