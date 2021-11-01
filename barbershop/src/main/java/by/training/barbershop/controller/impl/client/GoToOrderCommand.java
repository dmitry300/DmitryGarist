package by.training.barbershop.controller.impl.client;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.bean.Haircut;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToOrderCommand implements Command {
    private static final Logger logg = LogManager.getLogger(GoToOrderCommand.class);
    private static final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Router executeCommand(HttpServletRequest request) {
        try {
            List<Haircut> haircuts = serviceFactory.getHaircutService().findHaircuts();
            List<Barber> barbers = serviceFactory.getBarberService().findActiveBarbers();
            request.setAttribute("services", haircuts);
            request.setAttribute("barbers", barbers);
        } catch (ServiceException e) {
            logg.error("Service exception: {}", e.getMessage());
        }
        return new Router(PagePath.ORDER_PAGE, Router.RouterType.FORWARD);
    }
}
