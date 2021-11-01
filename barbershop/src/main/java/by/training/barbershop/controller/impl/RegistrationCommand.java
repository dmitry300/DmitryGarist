package by.training.barbershop.controller.impl;

import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserInfo;
import by.training.barbershop.bean.UserRole;
import by.training.barbershop.bean.UserStatus;
import by.training.barbershop.controller.*;
import by.training.barbershop.service.ServiceFactory;
import by.training.barbershop.service.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;


public class RegistrationCommand implements Command {
    private static final Logger logg = LogManager.getLogger(RegistrationCommand.class);

    @Override
    public Router executeCommand(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        String role = request.getParameter("role");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        String email = request.getParameter("email");
        String birthdayStr = request.getParameter("birthday");
        String phone = request.getParameter("phone");

        Date birthday = null;
        if (birthdayStr != null && !birthdayStr.equals("")) {
            birthday = Date.valueOf(birthdayStr);
        }
        long parsePhone = serviceFactory.getUserRequestValidation().parseTel(phone);
        UserRole userRole = UserRole.valueOf(role);

        HttpSession session = request.getSession();
        if (!serviceFactory.getUserRequestValidation().isSubmittedPassword(password, repeatPassword)) {
            session.setAttribute(SessionAttribute.IS_SIGNUP_ERROR, true);
            session.setAttribute(SessionAttribute.ERROR_KEY, BundleKey.SIGNUP_INVALID_REQUEST);
            return new Router(PagePath.REGISTRATION_PAGE_REDIRECT, Router.RouterType.REDIRECT);
        }

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(userRole);
        user.setUserStatus(UserStatus.PERMITTED);
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setSurname(surname);
        userInfo.setPatronymic(patronymic);
        userInfo.setEmail(email);
        userInfo.setPhone(parsePhone);
        userInfo.setBirthday(birthday);
        user.setUserInfo(userInfo);

        try {
            if (serviceFactory.getUserServiceImpl().isLoginFreeForNewUser(login)) {
                logg.log(Level.DEBUG, "Login already exists");
                session.setAttribute(SessionAttribute.IS_SIGNUP_ERROR, true);
                session.setAttribute(SessionAttribute.ERROR_KEY, BundleKey.SIGNUP_LOGIN_NOT_AVAILABLE);
                return new Router(PagePath.REGISTRATION_PAGE_REDIRECT, Router.RouterType.REDIRECT);
            }
            if (serviceFactory.getUserServiceImpl().addNewUser(user)) {
                return new Router(PagePath.HOME_PAGE, Router.RouterType.FORWARD);
            } else {
                return new Router(PagePath.ERROR_500_PAGE, Router.RouterType.REDIRECT);
            }
        } catch (ServiceException e) {
            logg.error("Error user registration: {} ", e.getMessage());
            return new Router("адрес страницы ошибки..", Router.RouterType.REDIRECT);
        }
    }
}
