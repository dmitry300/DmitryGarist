package by.training.task06.service.impl;

import by.training.task06.service.Reader;
import by.training.task06.service.exception.ServiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {
    @Override
    public int consoleReader(String message) throws ServiceException {
        String inputLine;
        System.out.print(message);
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() != 0) {
                return Integer.parseInt(inputLine);
            }
        } catch (IOException e) {
            throw new ServiceException(e);
        }
        return 0;

    }
}
