package by.training.barbershop.controller.filter;

import by.training.barbershop.bean.UserRole;
import by.training.barbershop.controller.PagePath;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AdminForwardFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        UserRole userRole = (UserRole) httpServletRequest.getSession().getAttribute("userRole");
        if (userRole == null || !userRole.equals(UserRole.ADMIN)) {
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher(PagePath.HOME_PAGE);
            requestDispatcher.forward(servletRequest, servletResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
