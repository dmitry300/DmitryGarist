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
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ListOfDismissedBarbersCommand implements Command {
    private static final Logger logg = LogManager.getLogger(ListOfDismissedBarbersCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<Barber> barbers;
        try {
            barbers = serviceFactory.getBarberService().findDismissedBarbers();
        } catch (ServiceException e) {
            logg.error(e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
        request.setAttribute("barbers", barbers);
        request.setAttribute("now", Date.valueOf(LocalDate.now()));
        return new Router(PagePath.LIST_BARBERS_PAGE, Router.RouterType.FORWARD);
    }
}
