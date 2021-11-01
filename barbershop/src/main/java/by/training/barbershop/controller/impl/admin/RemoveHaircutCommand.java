package by.training.barbershop.controller.impl.admin;

import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class RemoveHaircutCommand implements Command {
    private static final Logger logg = LogManager.getLogger(RemoveHaircutCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String haircutIdParameter = request.getParameter("haircutId");

        try {

            if (!serviceFactory.getHaircutService().removeHaircut(Integer.parseInt(haircutIdParameter))) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }
        } catch (ServiceException | SQLException e) {
            logg.error("Service exception: {}", e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
        return new Router(PagePath.LIST_HAIRCUTS_PAGE_REDIRECT, Router.RouterType.REDIRECT);
    }
}
