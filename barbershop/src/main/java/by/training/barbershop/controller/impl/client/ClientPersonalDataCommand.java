package by.training.barbershop.controller.impl.client;

import by.training.barbershop.bean.User;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.controller.SessionAttribute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ClientPersonalDataCommand implements Command {
    private static final Logger logg = LogManager.getLogger(ClientPersonalDataCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.USER);
        if (user == null) {
            return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
        }
        return new Router(PagePath.CLIENT_PERSONAL_DATA, Router.RouterType.FORWARD);
    }
}
