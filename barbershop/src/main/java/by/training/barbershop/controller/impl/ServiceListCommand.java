package by.training.barbershop.controller.impl;

import by.training.barbershop.bean.Haircut;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ServiceListCommand implements Command {
    private static final Logger logg = LogManager.getLogger(ServiceListCommand.class);
    private static final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Router executeCommand(HttpServletRequest request) {
        try {
            List<Haircut> haircuts = serviceFactory.getHaircutService().findHaircuts();
            request.setAttribute("services",haircuts);
        } catch (ServiceException e) {
            logg.error("Service exception: {}", e.getMessage());
        }
        return new Router(PagePath.SERVICES_PAGE, Router.RouterType.FORWARD);
    }
}
