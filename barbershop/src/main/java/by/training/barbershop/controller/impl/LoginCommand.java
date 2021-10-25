package by.training.barbershop.controller.impl;

import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserStatus;
import by.training.barbershop.controller.*;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private static final Logger logg = LogManager.getLogger(LoginCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String password = request.getParameter("password");
        String login = request.getParameter("login");
        HttpSession session = request.getSession();
        try {
            User user = serviceFactory.getUserServiceImpl().findRegisteredUser(login, password);
            if (user == null) {
                session.setAttribute(SessionAttribute.IS_LOGIN_OR_PASSWORD_ERROR, true);
                session.setAttribute(SessionAttribute.ERROR_KEY, BundleKey.LOGIN_OR_PASSWORD_ERROR);
                return new Router(PagePath.LOGIN_PAGE_REDIRECT, Router.RouterType.REDIRECT);
            }
            if (user.getUserStatus().equals(UserStatus.BLOCKED)){
                session.setAttribute(SessionAttribute.ACCOUNT_IS_BLOCKED,true);
                session.setAttribute(SessionAttribute.ERROR_KEY,BundleKey.LOGIN_USER_BLOCKED);
                return new Router(PagePath.LOGIN_PAGE_REDIRECT, Router.RouterType.REDIRECT);
            }
            session.setAttribute(SessionAttribute.USER, user);
            return new Router(PagePath.HOME_PAGE_REDIRECT, Router.RouterType.REDIRECT);
        } catch (ServiceException e) {
            logg.error("Error finding registered user, {} ", e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
    }
}
