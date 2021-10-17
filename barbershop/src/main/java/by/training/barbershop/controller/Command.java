package by.training.barbershop.controller;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Router executeCommand(HttpServletRequest request);
}
