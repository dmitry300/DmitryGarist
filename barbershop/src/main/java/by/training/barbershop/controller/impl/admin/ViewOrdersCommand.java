package by.training.barbershop.controller.impl.admin;

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

public class ViewOrdersCommand implements Command {
    private static final Logger logg = LogManager.getLogger(ViewOrdersCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int userId = Integer.parseInt(request.getParameter("userId"));

        try {
            List<Order> orders = serviceFactory.getOrderService().findOrderByUserId(userId);
            request.setAttribute("orders",orders);
        } catch (ServiceException e) {
            logg.error(e.getMessage());
        }
        return new Router(PagePath.CLIENT_ORDERS_MANAGE, Router.RouterType.FORWARD);
    }
}
