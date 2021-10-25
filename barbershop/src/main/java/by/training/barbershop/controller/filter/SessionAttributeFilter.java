package by.training.barbershop.controller.filter;

import by.training.barbershop.controller.CommandType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static by.training.barbershop.controller.CommandType.GO_TO_LOGIN;
import static by.training.barbershop.controller.SessionAttribute.*;

public class SessionAttributeFilter implements Filter {
    private Map<CommandType, List<String>> attributesToRemove;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        attributesToRemove = new EnumMap<>(CommandType.class);
        attributesToRemove.put(GO_TO_LOGIN, List.of(IS_LOGIN_OR_PASSWORD_ERROR,ACCOUNT_IS_BLOCKED));
        attributesToRemove.put(CommandType.GO_TO_REGISTRATION, List.of(IS_SIGNUP_ERROR));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String commandString = httpServletRequest.getParameter("command");
        CommandType currentCommand = CommandType.valueOf(commandString.toUpperCase());
        HttpSession session = httpServletRequest.getSession();
        attributesToRemove.forEach((command, attributes) -> {
            if (currentCommand != command) {
                attributes.forEach(session::removeAttribute);
            }
        });
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
