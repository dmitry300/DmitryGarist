package by.training.barbershop.service;

import by.training.barbershop.bean.Haircut;
import by.training.barbershop.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface HaircutService {
    List<Haircut> findHaircuts() throws ServiceException;

    Haircut findHaircutById(int id) throws ServiceException;

    boolean addHaircut(Haircut haircut) throws ServiceException, SQLException;

    boolean removeHaircut(int id) throws ServiceException, SQLException;

    Haircut updateHaircut(Haircut haircut) throws ServiceException;
}
