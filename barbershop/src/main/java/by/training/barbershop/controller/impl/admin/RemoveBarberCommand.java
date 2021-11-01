package by.training.barbershop.controller.impl.admin;

import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RemoveBarberCommand implements Command {
    private static final Logger logg = LogManager.getLogger(RemoveBarberCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String haircutIdParameter = request.getParameter("barberId");

        try {
            if (!serviceFactory.getBarberService().removeBarber(Integer.parseInt(haircutIdParameter))) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }
        } catch (ServiceException e) {
            logg.error("Service exception: {}", e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
        return new Router(PagePath.LIST_BARBERS_PAGE_REDIRECT, Router.RouterType.REDIRECT);
    }
}
