package by.training.task06.service;

import by.training.task06.service.exception.ServiceException;

import java.io.IOException;

public interface Reader {
    int consoleReader(String message) throws IOException, ServiceException;
}
