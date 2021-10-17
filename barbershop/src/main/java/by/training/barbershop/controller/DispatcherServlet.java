package by.training.barbershop.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    private static final Logger logg = LogManager.getLogger(DispatcherServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter("command");
        Command command = CommandProvider.getInstance().getCommand(commandName);
        Router router;
        router = command.executeCommand(request);
        switch (router.getRouterType()) {
            case FORWARD -> request.getRequestDispatcher(router.getPagePath()).forward(request, response);
            case REDIRECT -> response.sendRedirect(request.getContextPath() + router.getPagePath());
            default -> {
                logg.error("incorrect route type {}", router.getRouterType());
                response.sendRedirect(PagePath.ERROR_500_PAGE);
            }
        }
    }
}
