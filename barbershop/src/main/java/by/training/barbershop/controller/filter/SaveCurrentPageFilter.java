package by.training.barbershop.controller.filter;

import by.training.barbershop.controller.CommandType;
import by.training.barbershop.controller.SessionAttribute;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SaveCurrentPageFilter implements Filter {
    private static final String GET_METHOD = "GET";
    private static final String QUESTION_MARK = "?";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if (httpServletRequest.getMethod().equals(GET_METHOD)) {

            String contextPath = httpServletRequest.getContextPath();
            String uri = httpServletRequest.getRequestURI();
            int startIndex = uri.indexOf(contextPath) + contextPath.length();
            String substring = uri.substring(startIndex);
            String queryParameters = httpServletRequest.getQueryString();
            String queryLine = queryParameters == null ? substring : substring + QUESTION_MARK + queryParameters;

            String commandString = httpServletRequest.getParameter("command");
            CommandType currentCommand = CommandType.valueOf(commandString.toUpperCase());
            if (currentCommand != CommandType.LANGUAGE) {
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute(SessionAttribute.PREVIOUS_QUERY, queryLine);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
