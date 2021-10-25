package by.training.barbershop.controller.impl.admin;

import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ChangeClientStatusCommand implements Command {
    private static final Logger logg = LogManager.getLogger(ChangeClientStatusCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int userId = Integer.parseInt(request.getParameter("userId"));
        try {
            if (!serviceFactory.getUserServiceImpl().changeStatusUser(userId)) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }
        } catch (ServiceException e) {
            logg.error("Service exception: {}", e.getMessage());
        }
        return new Router(PagePath.CLIENT_LIST_PAGE_REDIRECT, Router.RouterType.REDIRECT);
    }
}
