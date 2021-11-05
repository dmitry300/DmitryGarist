package by.training.barbershop.controller.impl.admin;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.bean.Haircut;
import by.training.barbershop.bean.Order;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToEditOrderCommand implements Command {
    private static final Logger logg = LogManager.getLogger(GoToEditOrderCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String orderIdParameter = request.getParameter("orderId");
        String isToActivePageParameter = request.getParameter("toActivePage");

        if (orderIdParameter.isEmpty()) {
            return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
        }

        try {
            List<Haircut> haircuts = serviceFactory.getHaircutService().findHaircuts();
            List<Barber> barbers = serviceFactory.getBarberService().findActiveBarbers();
            Order order = serviceFactory.getOrderService().findOrderById(Integer.parseInt(orderIdParameter));
            if (order == null) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }
            if (isToActivePageParameter != null) {
                int isToActive = Integer.parseInt(isToActivePageParameter);
                request.setAttribute("toActive", isToActive);
            }
            request.setAttribute("order", order);
            request.setAttribute("haircuts", haircuts);
            request.setAttribute("barbers", barbers);
        } catch (ServiceException e) {
            logg.error(e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }

        return new Router(PagePath.EDIT_ORDER_PAGE, Router.RouterType.FORWARD);
    }
}
