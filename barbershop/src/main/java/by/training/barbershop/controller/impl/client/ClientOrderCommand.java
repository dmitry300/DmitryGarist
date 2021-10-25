package by.training.barbershop.controller.impl.client;

import by.training.barbershop.bean.Order;
import by.training.barbershop.bean.User;
import by.training.barbershop.controller.*;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ClientOrderCommand implements Command {
    private static final Logger logg = LogManager.getLogger(ClientOrderCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.USER);
        if (user == null) {
            return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
        }
        try {
            List<Order> orders = serviceFactory.getOrderService().findOrderByUserId(user.getId());
            request.setAttribute(RequestAttribute.ORDERS, orders);
        } catch (ServiceException e) {
            logg.error(e.getMessage());
        }
        return new Router(PagePath.CLIENT_ORDERS, Router.RouterType.FORWARD);
    }
}
