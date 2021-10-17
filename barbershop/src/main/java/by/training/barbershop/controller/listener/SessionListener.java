package by.training.barbershop.controller.listener;

import by.training.barbershop.controller.SessionAttribute;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    private static final String DEFAULT_LOCALE = "ru";
    private static final String DEFAULT_PREVIOUS_QUERY = "/controller?command=home";
    private static final boolean DEFAULT_DESCRIPTION_EXISTS_VALUE = false;


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setAttribute(SessionAttribute.LOCALE, DEFAULT_LOCALE);// default attributes
        session.setAttribute(SessionAttribute.PREVIOUS_QUERY, DEFAULT_PREVIOUS_QUERY);
        session.setAttribute(SessionAttribute.DESCRIPTION_EXISTS, DEFAULT_DESCRIPTION_EXISTS_VALUE);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
