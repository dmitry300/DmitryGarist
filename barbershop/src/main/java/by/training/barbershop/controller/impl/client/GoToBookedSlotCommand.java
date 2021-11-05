package by.training.barbershop.controller.impl.client;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.bean.Order;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public class GoToBookedSlotCommand implements Command {
    private static final Logger logg = LogManager.getLogger(GoToBookedSlotCommand.class);
    private static final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Router executeCommand(HttpServletRequest request) {
        String dateSelectParameter = request.getParameter("dataSelect");

        try {
            List<Barber> barbers = serviceFactory.getBarberService().findActiveBarbers();
            List<Order> bookedTimePointInTheDay = serviceFactory.getOrderService().findBookedTimePoints(LocalDate.parse(dateSelectParameter));
            request.setAttribute("bookedTimeOrder", bookedTimePointInTheDay);
            request.setAttribute("barbers", barbers);
        } catch (ServiceException e) {
            logg.error("Service exception: {}", e.getMessage());
        }
        return new Router(PagePath.LIST_BOOKED_TIME_PAGE, Router.RouterType.FORWARD);
    }
}
