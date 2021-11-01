package by.training.barbershop.controller.impl.admin;

import by.training.barbershop.bean.Order;
import by.training.barbershop.bean.OrderStatus;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ChangeOrderStatusCommand implements Command {
    private static final Logger logg = LogManager.getLogger(ChangeOrderStatusCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String status = request.getParameter("status_order");
        String orderId = request.getParameter("orderId");
        String userIdParameter = request.getParameter("userId");
        try {
            Order order = serviceFactory.getOrderService().findOrderById(Integer.parseInt(orderId));
            if (order == null) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }
            if (!serviceFactory.getOrderService().changeStatusOrder(order, OrderStatus.valueOf(status.toUpperCase()))) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }
            if (userIdParameter == null) {
                return new Router(PagePath.ACTIVE_ORDERS_PAGE_REDIRECT, Router.RouterType.REDIRECT);
            }

        } catch (ServiceException e) {
            logg.error(e.getMessage());
        }
        int userId = Integer.parseInt(userIdParameter);
        return new Router(PagePath.CLIENT_ORDERS_MANAGE_REDIRECT + userId, Router.RouterType.REDIRECT);
    }
}
