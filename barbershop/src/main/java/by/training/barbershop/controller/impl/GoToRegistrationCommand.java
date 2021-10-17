package by.training.barbershop.controller.impl;

import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;

import javax.servlet.http.HttpServletRequest;

public class GoToRegistrationCommand implements Command {
    @Override
    public Router executeCommand(HttpServletRequest request) {
        return new Router(PagePath.REGISTRATION_PAGE, Router.RouterType.FORWARD);
    }
}
