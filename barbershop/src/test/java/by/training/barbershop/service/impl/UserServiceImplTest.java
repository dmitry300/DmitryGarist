package by.training.barbershop.service.impl;

import by.training.barbershop.dao.Transaction;
import by.training.barbershop.dao.impl.DaoFactory;
import by.training.barbershop.dao.pool.ConnectionPool;
import by.training.barbershop.service.UserService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserServiceImplTest {
    private UserService userService;
    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private final Transaction transaction = daoFactory.getTransactionDao();

    @BeforeClass
    public void initPool() {
        userService = new UserServiceImpl();

    }

    @Test
    public void testAddNewUser() {
    }


}