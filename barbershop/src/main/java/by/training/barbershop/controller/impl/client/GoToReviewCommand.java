package by.training.barbershop.controller.impl.client;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.bean.Haircut;
import by.training.barbershop.bean.Review;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToReviewCommand implements Command {
    private static final Logger logg = LogManager.getLogger(GoToReviewCommand.class);
    private static final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Router executeCommand(HttpServletRequest request) {
        String barberIdParameter = request.getParameter("barberId");
        int barberId = Integer.parseInt(barberIdParameter);
        try {
            List<Review> reviews = serviceFactory.getReviewService().findReviewsByBarberId(barberId);
            Barber barber = serviceFactory.getBarberService().findBarberById(barberId);
            request.setAttribute("reviews", reviews);
            request.setAttribute("barber", barber);
        } catch (ServiceException e) {
            logg.error("Service exception: {}", e.getMessage());
        }
        return new Router(PagePath.REVIEW_BARBER_PAGE, Router.RouterType.FORWARD);
    }
}
