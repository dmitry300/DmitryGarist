package by.training.barbershop.service;

import by.training.barbershop.bean.Barber;
import by.training.barbershop.service.exception.ServiceException;

import javax.servlet.http.Part;
import java.util.List;

public interface BarberService {
    List<Barber> findActiveBarbers() throws ServiceException;

    List<Barber> findDismissedBarbers() throws ServiceException;

    Barber findBarberById(int id) throws ServiceException;

    boolean addNewBarber(Barber barber, List<Part> imageParts) throws ServiceException;

    boolean removeBarber(int id) throws ServiceException;

    boolean updateBarberWithImg(Barber barber,List<Part> imageParts) throws ServiceException;
    boolean updateBarber(Barber barber) throws ServiceException;
}
