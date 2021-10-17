package by.training.barbershop.controller.impl;

import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.controller.SessionAttribute;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public Router executeCommand(HttpServletRequest request) {
        request.getSession().removeAttribute(SessionAttribute.USER);
        return new Router(PagePath.HOME_PAGE, Router.RouterType.FORWARD);
    }
}
