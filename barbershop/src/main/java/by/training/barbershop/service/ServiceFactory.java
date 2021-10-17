package by.training.barbershop.service;

import by.training.barbershop.service.impl.BarberServiceImpl;
import by.training.barbershop.service.impl.HaircutServiceImpl;
import by.training.barbershop.service.impl.UserServiceImpl;
import by.training.barbershop.service.validator.ValidatorRepeatPassword;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userServiceImpl = new UserServiceImpl();
    private final ValidatorRepeatPassword validatorRepeatPassword = new ValidatorRepeatPassword();
    private final HaircutService haircutService = new HaircutServiceImpl();
    private final BarberService barberService = new BarberServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserServiceImpl() {
        return userServiceImpl;
    }

    public ValidatorRepeatPassword getValidatorRepeatPassword() {
        return validatorRepeatPassword;
    }

    public HaircutService getHaircutService() {
        return haircutService;
    }

    public BarberService getBarberService() {
        return barberService;
    }
}
