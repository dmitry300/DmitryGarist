package by.training.barbershop.service;

import by.training.barbershop.bean.Haircut;
import by.training.barbershop.service.exception.ServiceException;

import java.util.List;

public interface HaircutService {
    List<Haircut> findHaircuts() throws ServiceException;
}
