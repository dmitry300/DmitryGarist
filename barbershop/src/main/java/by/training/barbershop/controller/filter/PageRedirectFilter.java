package by.training.barbershop.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//public class PageRedirectFilter implements Filter { //фильтрует обращение к jsp страницам
//    private String indexPath;                       //перехватывает и перекидывет на index.jsp
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        indexPath = filterConfig.getInitParameter("INDEX_PATH");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + indexPath);
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//        indexPath = null;
//    }
//}
