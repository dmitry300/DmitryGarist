package by.training.barbershop.controller.impl.admin;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.controller.Command;
import by.training.barbershop.controller.PagePath;
import by.training.barbershop.controller.Router;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class EditBarberCommand implements Command {
    private static final Logger logg = LogManager.getLogger(EditBarberCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String nameParameter = request.getParameter("name");
        String surnameParameter = request.getParameter("surname");
        String patronymicParameter = request.getParameter("patronymic");
        String phoneParameter = request.getParameter("phone");
        String birthdayParameter = request.getParameter("birthday");
        String tiktokParameter = request.getParameter("tiktok");
        String startJobParameter = request.getParameter("startJob");
        String endJobParameter = request.getParameter("endJob");
        try {
            List<Part> imageParts = request.getParts().stream()
                    .filter(part -> part.getName().equals("photo") && part.getSize() > 0)
                    .toList();
            int barberId = Integer.parseInt(request.getParameter("barberId"));
            Barber barber = serviceFactory.getBarberService().findBarberById(barberId);

            if (!nameParameter.isEmpty()) {
                barber.setName(nameParameter);
            }
            if (!surnameParameter.isEmpty()) {
                barber.setSurname(surnameParameter);
            }
            if (!patronymicParameter.isEmpty()) {
                barber.setPatronymic(patronymicParameter);
            }
            if (!phoneParameter.isEmpty()) {
                long phone = serviceFactory.getUserRequestValidation().parseTel(phoneParameter);
                barber.setPhone(phone);
            }
            if (!birthdayParameter.isEmpty()) {
                barber.setBirthday(Date.valueOf(birthdayParameter));
            }
            if (!tiktokParameter.isEmpty()) {
                barber.setTiktokLink(tiktokParameter);
            }
            if (!startJobParameter.isEmpty()) {
                barber.setStartJob(Date.valueOf(startJobParameter));
            }
            if (!endJobParameter.isEmpty()) {
                barber.setEndJob(Date.valueOf(endJobParameter));
            }
//            if (!serviceFactory.getBarberService().updateBarber(barber)) {
//                logg.error("error get parameters to service");
//                return new Router(PagePath.ERROR_404_PAGE, Router.RouterType.FORWARD);
//            }
            if (imageParts.isEmpty()) {
                serviceFactory.getBarberService().updateBarber(barber);
            } else {
                serviceFactory.getBarberService().updateBarberWithImg(barber, imageParts);
            }
        } catch (ServiceException | ServletException | IOException e) {
            logg.error(e.getMessage(), e);
            return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
        }
        return new Router(PagePath.LIST_BARBERS_PAGE_REDIRECT, Router.RouterType.REDIRECT);
    }
}
