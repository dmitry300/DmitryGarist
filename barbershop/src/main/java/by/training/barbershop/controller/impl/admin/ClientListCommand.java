package by.training.barbershop.controller.impl.admin;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.bean.User;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ClientListCommand implements Command {
    private static final Logger logg = LogManager.getLogger(ClientListCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        try {
            List<User> users = serviceFactory.getUserServiceImpl().findAllUser();
            request.setAttribute("users", users);
        } catch (ServiceException e) {
            logg.error("Service exception: {}", e.getMessage());
        }
        return new Router(PagePath.CLIENT_LIST_PAGE, Router.RouterType.FORWARD);
    }

}
