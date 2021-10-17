package by.training.barbershop.controller.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {
    private static final Logger logg = LogManager.getLogger(SessionAttributeListener.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        logg.info("add: {} : {} : {} ", httpSessionBindingEvent.getClass().getSimpleName() ,
                httpSessionBindingEvent.getName(), httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        logg.info("remove: {} : {} : {} ", httpSessionBindingEvent.getClass().getSimpleName() ,
                httpSessionBindingEvent.getName(), httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        logg.info("replace: {} : {} : {} ", httpSessionBindingEvent.getClass().getSimpleName() ,
                httpSessionBindingEvent.getName(), httpSessionBindingEvent.getValue());
    }
}
