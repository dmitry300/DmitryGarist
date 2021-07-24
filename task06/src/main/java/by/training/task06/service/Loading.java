package by.training.task06.service;

import by.training.task06.service.exception.ServiceException;

public interface Loading {
    Object read(String fileName) throws ServiceException;
}
