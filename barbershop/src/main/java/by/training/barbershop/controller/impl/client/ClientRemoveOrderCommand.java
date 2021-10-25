package by.training.barbershop.controller.impl.client;

import by.training.barbershop.bean.User;
import by.training.barbershop.controller.*;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ClientRemoveOrderCommand implements Command {
    private static final Logger logg = LogManager.getLogger(ClientRemoveOrderCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.USER);
        if (user == null) {
            return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
        }
        try {
            if (!serviceFactory.getOrderService().removeOrderById(orderId)) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }
        } catch (ServiceException e) {
            logg.error(e.getMessage());
        }
        return new Router(PagePath.CLIENT_ORDERS_REDIRECT, Router.RouterType.REDIRECT);
    }
}
