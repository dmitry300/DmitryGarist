package by.training.barbershop.service;

import by.training.barbershop.service.impl.*;
import by.training.barbershop.service.validator.UserRequestValidation;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userServiceImpl = new UserServiceImpl();
    private final UserRequestValidation userRequestValidation = new UserRequestValidation();
    private final HaircutService haircutService = new HaircutServiceImpl();
    private final BarberService barberService = new BarberServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();
    private final ReviewService reviewService= new ReviewServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserServiceImpl() {
        return userServiceImpl;
    }

    public UserRequestValidation getUserRequestValidation() {
        return userRequestValidation;
    }

    public HaircutService getHaircutService() {
        return haircutService;
    }

    public BarberService getBarberService() {
        return barberService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public ReviewService getReviewService() {
        return reviewService;
    }
}
