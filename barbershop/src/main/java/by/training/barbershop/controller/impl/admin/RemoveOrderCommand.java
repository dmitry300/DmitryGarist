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

public class RemoveOrderCommand implements Command {
    private static final Logger logg = LogManager.getLogger(RemoveOrderCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String orderIdParameter = request.getParameter("orderId");
        String userIdParameter = request.getParameter("userId");
        int userId = Integer.parseInt(userIdParameter);
        int orderId = Integer.parseInt(orderIdParameter);
        logg.info(userId);
        try {
            Order order = serviceFactory.getOrderService().findOrderById(orderId);
            if (order == null) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }
            if (!serviceFactory.getOrderService().removeOrderById(orderId)) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }

        } catch (ServiceException e) {
            logg.error(e.getMessage());
        }
        return new Router(PagePath.CLIENT_ORDERS_MANAGE_REDIRECT + userId, Router.RouterType.REDIRECT);
    }
}