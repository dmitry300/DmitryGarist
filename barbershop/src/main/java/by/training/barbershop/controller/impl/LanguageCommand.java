package by.training.barbershop.controller.impl;

import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.Router;
import by.training.barbershop.controller.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LanguageCommand implements Command {
    private static final String RUSSIAN_LOCALE = "ru";
    private static final String ENGLISH_LOCALE = "en";

    @Override
    public Router executeCommand(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String previousQuery = (String) session.getAttribute(SessionAttribute.PREVIOUS_QUERY);
        String language = request.getParameter("language");

        if (language != null
                && (language.equals(RUSSIAN_LOCALE) || language.equals(ENGLISH_LOCALE))) {
            session.setAttribute(SessionAttribute.LOCALE, language);
        }
        return new Router(previousQuery, Router.RouterType.REDIRECT);
    }
}
