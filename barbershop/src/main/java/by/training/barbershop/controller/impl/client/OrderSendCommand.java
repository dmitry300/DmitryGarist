package by.training.barbershop.controller.impl.client;

import by.training.barbershop.bean.*;
import by.training.barbershop.controller.*;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import by.training.barbershop.service.validator.DateTimeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OrderSendCommand implements Command {
    private static final Logger logg = LogManager.getLogger(OrderSendCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String idHaircut = request.getParameter("haircut");
        String idBarber = request.getParameter("barber");
        String data = request.getParameter("data");
        String time = request.getParameter("time");

        if (!DateTimeValidator.isValidDate(data) || !DateTimeValidator.isValidTime(time)) {
            return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
        }
        LocalDate localDate = LocalDate.parse(data);
        LocalTime localTime = LocalTime.parse(time);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        HttpSession session = request.getSession();
        if (!DateTimeValidator.isValidDateTime(localDateTime)) {
            session.setAttribute(SessionAttribute.IS_NOT_DATA_TIME_VALID, true);
            session.setAttribute(SessionAttribute.ERROR_KEY, BundleKey.ORDER_INVALID_DATE);
            return new Router(PagePath.ORDER_PAGE_REDIRECT, Router.RouterType.REDIRECT);
        }

        Barber barber = new Barber();
        barber.setId(Integer.parseInt(idBarber));
        Haircut haircut = new Haircut();
        haircut.setId(Integer.parseInt(idHaircut));

        User user = (User) session.getAttribute("user");
        Order order = new Order();
        OrderStatus orderStatus = OrderStatus.valueOf("WAITING");
        order.setStatus(orderStatus);
        order.setBarber(barber);
        order.setHaircut(haircut);
        order.setDateTimePlane(Timestamp.valueOf(localDateTime));
        order.setUser(user);

        try {
            if (!serviceFactory.getOrderService().addOrder(order)) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }
        } catch (ServiceException e) {
            logg.error("Error adding order, {}", e.getMessage());
            return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
        }
        return new Router(PagePath.ORDER_WAITING_REDIRECT, Router.RouterType.REDIRECT);
    }
}
