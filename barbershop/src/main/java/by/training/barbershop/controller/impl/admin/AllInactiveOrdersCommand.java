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
import java.util.List;

public class AllInactiveOrdersCommand implements Command {
    private static final Logger logg = LogManager.getLogger(AllInactiveOrdersCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String orderStatusParameter = request.getParameter("orderStatus");
        List<Order> orders;
        try {
            if (orderStatusParameter != null) {
                orders = serviceFactory.getOrderService().findActiveOrderByStatus(OrderStatus.valueOf(orderStatusParameter),false );
            } else {
                orders = serviceFactory.getOrderService().findAllActiveOrder(false);
            }
        } catch (ServiceException e) {
            logg.error(e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
        request.setAttribute("orders", orders);
        return new Router(PagePath.ACTIVE_ORDERS_PAGE, Router.RouterType.FORWARD);
    }
}
