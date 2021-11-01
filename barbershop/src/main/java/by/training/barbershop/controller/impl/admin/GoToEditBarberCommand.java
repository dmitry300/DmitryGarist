package by.training.barbershop.controller.impl.admin;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class GoToEditBarberCommand implements Command {
    private static final Logger logg = LogManager.getLogger(GoToEditBarberCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String barberIdParameter = request.getParameter("barberId");

        if (barberIdParameter.isEmpty()) {
            return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.REDIRECT);
        }
        try {
            Barber barber = serviceFactory.getBarberService().findBarberById(Integer.parseInt(barberIdParameter));
            if (barber == null) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.REDIRECT);
            }
            request.setAttribute("barber", barber);
        } catch (ServiceException e) {
            logg.error(e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }

        return new Router(PagePath.EDIT_BARBER_PAGE, Router.RouterType.FORWARD);
    }
}
