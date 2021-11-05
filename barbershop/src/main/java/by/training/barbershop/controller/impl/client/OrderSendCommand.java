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
import java.util.List;

public class OrderSendCommand implements Command {
    private static final Logger logg = LogManager.getLogger(OrderSendCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String idHaircutParameter = request.getParameter("haircut");
        String idBarberParameter = request.getParameter("barber");
        String dataParameter = request.getParameter("data");
        String timeParameter = request.getParameter("time");

        if (!DateTimeValidator.isValidDate(dataParameter) || !DateTimeValidator.isValidTime(timeParameter)) {
            return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
        }
        LocalDate localDate = LocalDate.parse(dataParameter);
        LocalTime localTime = LocalTime.parse(timeParameter);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        HttpSession session = request.getSession();
        if (!DateTimeValidator.isValidDateTime(localDateTime)) {
            session.setAttribute(SessionAttribute.IS_NOT_DATA_TIME_VALID, true);
            session.setAttribute(SessionAttribute.ERROR_KEY, BundleKey.ORDER_INVALID_DATE);
            return new Router(PagePath.ORDER_PAGE_REDIRECT, Router.RouterType.REDIRECT);
        }
        Barber barber = new Barber();
        int idBarber = Integer.parseInt(idBarberParameter);
        barber.setId(idBarber);
        Haircut haircut = new Haircut();
        haircut.setId(Integer.parseInt(idHaircutParameter));

        User user = (User) session.getAttribute("user");
        Order order = new Order();
        OrderStatus orderStatus = OrderStatus.valueOf("WAITING");
        order.setStatus(orderStatus);
        order.setBarber(barber);
        order.setHaircut(haircut);
        order.setDateTimePlane(Timestamp.valueOf(localDateTime));
        order.setUser(user);

        try {
            List<Order> bookedTimesOrder = serviceFactory.getOrderService().findBookedTimePoints(localDate);
            if (!bookedTimesOrder.isEmpty()) {
                for (var booked : bookedTimesOrder) {
                    if (booked.getBarber().getId() == idBarber && booked.getDateTimePlane().equals(Timestamp.valueOf(localDateTime))) {
                        session.setAttribute(SessionAttribute.IS_NOT_DATA_TIME_VALID, true);
                        session.setAttribute(SessionAttribute.ERROR_KEY, BundleKey.ORDER_INVALID_DATE);
                        return new Router(PagePath.ORDER_PAGE_REDIRECT, Router.RouterType.REDIRECT);
                    }
                }
            }
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
