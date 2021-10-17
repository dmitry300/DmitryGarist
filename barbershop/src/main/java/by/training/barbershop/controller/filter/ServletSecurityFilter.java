package by.training.barbershop.controller.filter;

import by.training.barbershop.bean.UserRole;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//public class ServletSecurityFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//        HttpSession httpSession = httpServletRequest.getSession();
//        UserRole userRole = (UserRole) httpSession.getAttribute("userRole");
//        if (userRole == null) {
//            userRole = UserRole.GUEST;
//            httpSession.setAttribute("userRole", userRole);
//            RequestDispatcher requestDispatcher = servletRequest.getServletContext()
//                    .getRequestDispatcher("/page/guest.jsp");
//            requestDispatcher.forward(httpServletRequest, httpServletResponse);
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
