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
import java.sql.SQLException;
import java.sql.Time;

public class AddHaircutCommand implements Command {
    private static final Logger logg = LogManager.getLogger(AddHaircutCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String nameParameter = request.getParameter("name");
        String timeParameter = request.getParameter("duration");
        String priceParameter = request.getParameter("price");

        if (priceParameter.isEmpty() || nameParameter.isEmpty() || timeParameter.isEmpty()) {
            return new Router(PagePath.LIST_HAIRCUTS_PAGE_REDIRECT, Router.RouterType.REDIRECT);
        }

        try {
            Haircut haircut = new Haircut();
            haircut.setName(nameParameter);
            haircut.setTime(Time.valueOf(timeParameter));
            haircut.setPrice(Double.parseDouble(priceParameter));
            if (!serviceFactory.getHaircutService().addHaircut(haircut)) {
                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
            }
        } catch (ServiceException | SQLException e) {
            logg.error("Service exception: {}", e.getMessage());
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
        return new Router(PagePath.LIST_HAIRCUTS_PAGE_REDIRECT, Router.RouterType.REDIRECT);
    }
}
