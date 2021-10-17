package by.training.barbershop.controller.impl;

import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;

import javax.servlet.http.HttpServletRequest;

public class GoToAboutUsCommand implements Command {
    @Override
    public Router executeCommand(HttpServletRequest request) {
        return new Router(PagePath.ABOUT_US_PAGE, Router.RouterType.FORWARD);
    }
}
