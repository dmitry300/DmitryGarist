package by.training.barbershop.controller.impl.admin;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.bean.Haircut;
import by.training.barbershop.bean.Order;
import by.training.barbershop.controller.*;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import by.training.barbershop.service.validator.DateTimeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class EditOrderCommand implements Command {
    private static final Logger logg = LogManager.getLogger(EditOrderCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String haircutIdParameter = request.getParameter("haircut");
        String barberIdParameter = request.getParameter("barber");
        String dataTimeParameter = request.getParameter("data-time");
        String userIdParameter = request.getParameter("userId");
        String orderIdParameter = request.getParameter("orderId");
        HttpSession session = request.getSession();

        try {
            int orderId = Integer.parseInt(orderIdParameter);
            int userId = Integer.parseInt(userIdParameter);
            Order order = serviceFactory.getOrderService().findOrderById(orderId);
            if (order != null) {
                if (!haircutIdParameter.isEmpty()) {
                    int haircutId = Integer.parseInt(haircutIdParameter);
                    order.getHaircut().setId(haircutId);
                }
                if (!barberIdParameter.isEmpty()) {
                    int barberId = Integer.parseInt(barberIdParameter);
                    order.getBarber().setId(barberId);
                }
                if (!dataTimeParameter.isEmpty()) {
                    LocalDateTime localDateTime = LocalDateTime.parse(dataTimeParameter);

                    if (!DateTimeValidator.isValidDateTime(localDateTime)) {
                        session.setAttribute(SessionAttribute.IS_NOT_DATA_TIME_VALID, true);
                        session.setAttribute(SessionAttribute.ERROR_KEY, BundleKey.ORDER_INVALID_DATE);
                        return new Router(PagePath.EDIT_ORDER_PAGE_REDIRECT + orderId, Router.RouterType.REDIRECT);
                    }
                    order.setDateTimePlane(Timestamp.valueOf(localDateTime));
                }
                serviceFactory.getOrderService().updateOrder(order);
            }
            return new Router(PagePath.CLIENT_ORDERS_MANAGE_REDIRECT + userId, Router.RouterType.REDIRECT);
        } catch (ServiceException e) {
            logg.error(e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
    }
}
