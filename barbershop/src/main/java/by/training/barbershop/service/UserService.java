package by.training.barbershop.service;

import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserInfo;
import by.training.barbershop.service.exception.ServiceException;

public interface UserService {
    User findRegisteredUser(String login, String password) throws ServiceException;
    boolean addNewUser(UserInfo userInfo) throws ServiceException;
    long parseTel(String number);
}
