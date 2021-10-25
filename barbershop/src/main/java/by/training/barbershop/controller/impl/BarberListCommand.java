package by.training.barbershop.controller.impl;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BarberListCommand implements Command {
    private static final Logger logg = LogManager.getLogger(BarberListCommand.class);
    private static final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Router executeCommand(HttpServletRequest request) {
        try {
            List<Barber> barbers = serviceFactory.getBarberService().findBarbers();
            request.setAttribute("barbers",barbers);
        } catch (ServiceException e) {
            logg.error("Service exception: {}", e);
        }
        return new Router(PagePath.BARBERS_PAGE, Router.RouterType.FORWARD);
    }
}
