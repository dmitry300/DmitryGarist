package by.training.barbershop.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequestEvent.getServletRequest();
        String uri = "Request initialized for " + httpServletRequest.getRequestURI();
        ServletContext context = servletRequestEvent.getServletContext();
        context.log(uri );
    }
}
