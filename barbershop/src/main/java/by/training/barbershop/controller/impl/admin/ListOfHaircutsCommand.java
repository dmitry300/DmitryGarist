package by.training.barbershop.controller.impl.admin;

import by.training.barbershop.bean.Haircut;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ListOfHaircutsCommand implements Command {
    private static final Logger logg = LogManager.getLogger(ListOfHaircutsCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<Haircut> haircuts;
        try {
            haircuts = serviceFactory.getHaircutService().findHaircuts();
        } catch (ServiceException e) {
            logg.error(e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
        request.setAttribute("haircuts", haircuts);
        return new Router(PagePath.LIST_HAIRCUTS_PAGE, Router.RouterType.FORWARD);
    }
}
