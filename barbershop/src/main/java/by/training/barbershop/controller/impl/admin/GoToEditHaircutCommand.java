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

public class GoToEditHaircutCommand implements Command {
    private static final Logger logg = LogManager.getLogger(GoToEditHaircutCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String haircutIdParameter = request.getParameter("haircutId");

        if (haircutIdParameter.isEmpty()) {
            return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.REDIRECT);
        }
        try {
            Haircut haircut = serviceFactory.getHaircutService().findHaircutById(Integer.parseInt(haircutIdParameter));
            if (haircut == null) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.REDIRECT);
            }
            request.setAttribute("haircut", haircut);
        } catch (ServiceException e) {
            logg.error(e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.FORWARD);
        }

        return new Router(PagePath.EDIT_HAIRCUT_PAGE, Router.RouterType.FORWARD);
    }
}
