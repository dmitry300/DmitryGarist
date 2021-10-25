package by.training.barbershop.service.validator;

import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserInfo;
import by.training.barbershop.controller.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class UserRequestValidation {
    public User validate(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.USER);
        UserInfo userInfo = user.getUserInfo();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String birthdayStr = request.getParameter("birthday");

        if (!login.isEmpty()) {
            user.setLogin(login);
        }
        if (!password.isEmpty() && !repeatPassword.isEmpty()) {
            user.setPassword(password);
        }
        if (!isSubmittedPassword(password, repeatPassword)){
            return null;
        }
        if (!name.isEmpty()) {
            userInfo.setName(name);
        }
        if (!surname.isEmpty()) {
            userInfo.setSurname(surname);
        }
        if (!patronymic.isEmpty()) {
            userInfo.setPatronymic(patronymic);
        }
        if (!email.isEmpty()) {
            userInfo.setEmail(email);
        }
        if (!birthdayStr.isEmpty()) {
            userInfo.setBirthday(Date.valueOf(birthdayStr));
        }
        if (!phone.isEmpty()) {
            userInfo.setPhone(parseTel(phone));
        }
        user.setUserInfo(userInfo);
        return user;
    }

    public boolean isSubmittedPassword(String password, String repeatedPassword) {
        return password.equals(repeatedPassword);
    }

    public long parseTel(String number) {
        return Long.parseLong(number.replaceAll("\\D", ""));
    }
}
