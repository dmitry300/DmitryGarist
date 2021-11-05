package by.training.barbershop.service;

import by.training.barbershop.bean.User;
import by.training.barbershop.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    User findRegisteredUser(String login, String password) throws ServiceException;

    List<User> findUsersByPage(int pageNumber) throws ServiceException;

    int calcPagesCountForUsers(int usersCount);

    boolean addNewUser(User user) throws ServiceException;

    User findUserById(int id) throws ServiceException;

    boolean updateUser(User user) throws ServiceException;

    boolean isLoginFreeForNewUser(String login) throws ServiceException;

    List<User> findAllUser() throws ServiceException;

    boolean changeStatusUser(int id) throws ServiceException;
}
