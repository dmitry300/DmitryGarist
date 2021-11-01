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
import java.sql.Time;

public class EditHaircutCommand implements Command {
    private static final Logger logg = LogManager.getLogger(EditHaircutCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String haircutIdParameter = request.getParameter("haircutId");
        String nameParameter = request.getParameter("name");
        String timeParameter = request.getParameter("duration");
        String priceParameter = request.getParameter("price");

        try {
            Haircut haircut = serviceFactory.getHaircutService().findHaircutById(Integer.parseInt(haircutIdParameter));
            if (!nameParameter.isEmpty()) {
                haircut.setName(nameParameter);
            }
            if (!timeParameter.isEmpty()) {
                haircut.setTime(Time.valueOf(timeParameter));
            }
            if (!priceParameter.isEmpty()) {
                haircut.setPrice(Double.parseDouble(priceParameter));
            }
            serviceFactory.getHaircutService().updateHaircut(haircut);
            return new Router(PagePath.LIST_HAIRCUTS_PAGE_REDIRECT, Router.RouterType.REDIRECT);
        } catch (ServiceException e) {
            logg.error("Service exception: {}", e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
    }
}
