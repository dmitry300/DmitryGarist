package by.training.barbershop.controller.impl.client;

import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;

import javax.servlet.http.HttpServletRequest;

public class GoToClientProfileCommand implements Command {
    @Override
    public Router executeCommand(HttpServletRequest request) {
        return new Router(PagePath.CLIENT_PROFILE, Router.RouterType.FORWARD);
    }
}
