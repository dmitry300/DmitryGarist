package by.training.barbershop.controller.filter;

import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserRole;
import by.training.barbershop.controller.BundleKey;
import by.training.barbershop.controller.CommandType;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.SessionAttribute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.EnumMap;
import java.util.List;

import static by.training.barbershop.controller.CommandType.*;

public class ServletSecurityFilter implements Filter {
    private static final Logger logg = LogManager.getLogger();
    private EnumMap<UserRole, List<CommandType>> availableCommands;

    @Override
    public void init(FilterConfig filterConfig) {
        availableCommands = new EnumMap<>(UserRole.class);
        availableCommands.put(UserRole.GUEST,
                List.of(LANGUAGE, LOGIN, REGISTRATION, HOME, GO_TO_LOGIN, GO_TO_REGISTRATION,
                        GO_TO_ABOUT_US, SERVICES, BARBERS, ERROR));

        availableCommands.put(UserRole.CLIENT,
                List.of(LANGUAGE, LOGIN, REGISTRATION, HOME, GO_TO_LOGIN, GO_TO_REGISTRATION,
                        GO_TO_ABOUT_US, SERVICES, BARBERS, ERROR, LOGOUT, ORDER, GO_TO_ORDER_WAITING,
                        CLIENT_PROFILE, CLIENT_ORDERS,CLIENT_PERSONAL_DATA,ORDER_WAITING,GO_TO_CLIENT_EDIT_PROFILE, CLIENT_EDIT_PERSONAL_DATA, CLIENT_REMOVE_ORDER,
                        GO_TO_REVIEW, ADD_REVIEW, REMOVE_REVIEW, EDIT_REVIEW, GO_TO_EDIT_REVIEW, GO_TO_BOOKED_SLOT));

        availableCommands.put(UserRole.ADMIN,
                List.of(LANGUAGE, LOGIN, REGISTRATION, HOME, GO_TO_LOGIN, GO_TO_REGISTRATION,
                        GO_TO_ABOUT_US, SERVICES, BARBERS, ERROR, LOGOUT, CLIENT_PROFILE, CLIENT_PERSONAL_DATA, CLIENT_EDIT_PERSONAL_DATA, CLIENT_REMOVE_ORDER,
                        GO_TO_REVIEW, ADD_REVIEW, REMOVE_REVIEW, EDIT_REVIEW, GO_TO_EDIT_REVIEW, CLIENTS_LIST, ACTIVE_ORDERS,
                        INACTIVE_ORDERS, LIST_HAIRCUTS, ACTIVE_BARBERS, DISMISSED_BARBERS, REMOVE_ORDER, REMOVE_BARBER, REMOVE_HAIRCUT,
                        ADD_BARBER, ADD_HAIRCUT, EDIT_BARBER, EDIT_HAIRCUT, EDIT_ORDER, GO_TO_EDIT_BARBER, GO_TO_EDIT_ORDER,
                        GO_TO_EDIT_HAIRCUT, CHANGE_ORDER_STATUS, CHANGE_USER_STATUS));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();

        User user = (User) session.getAttribute(SessionAttribute.USER);
        UserRole role;

        if (user == null) {
            role = UserRole.GUEST;
        } else {
            role = user.getRole();
        }
        String commandName = httpServletRequest.getParameter("command");
        CommandType currentCommand = CommandType.valueOf(commandName.toUpperCase());
        List<CommandType> availableCommandsForCurrentUser = availableCommands.get(role);

        if (!availableCommandsForCurrentUser.contains(currentCommand)) {
            session.setAttribute(SessionAttribute.ERROR_KEY, BundleKey.NOT_ENOUGH_GRANTS);
            logg.warn("Not enough GRANTS!");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + PagePath.ERROR_PAGE);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
