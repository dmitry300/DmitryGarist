package by.training.barbershop.controller.impl.client;

import by.training.barbershop.bean.User;
import by.training.barbershop.controller.*;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditProfileCommand implements Command {
    private static final Logger logg = LogManager.getLogger(EditProfileCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        User user = serviceFactory.getUserRequestValidation().validate(request);
        HttpSession session = request.getSession();
        try {
            if (user == null) {
                session.setAttribute(SessionAttribute.IS_SIGNUP_ERROR, true);
                session.setAttribute(SessionAttribute.ERROR_KEY, BundleKey.SIGNUP_INVALID_REQUEST);
                return new Router(PagePath.CLIENT_PERSONAL_DATA_REDIRECT, Router.RouterType.REDIRECT);
            }
            if (serviceFactory.getUserServiceImpl().updateUser(user)) {
                session.setAttribute(SessionAttribute.USER, user);
                return new Router(PagePath.CLIENT_PERSONAL_DATA_REDIRECT, Router.RouterType.REDIRECT);
            } else {
                return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
            }
        } catch (ServiceException e) {
            logg.error(e.getMessage());
            return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
        }
    }
}
