package by.training.barbershop.service;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.service.exception.ServiceException;

import java.util.List;

public interface BarberService {
    List<Barber> findBarbers() throws ServiceException;
}
