package by.training.xml.controller;

import by.training.xml.bean.Medicine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class XMLServlet extends HttpServlet {
    private static final Logger log = LogManager.getLogger(XMLServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String commandName = request.getParameter("command");
        Command command = CommandProvider.getInstance().getCommand(commandName);
        Set<Medicine> medicines = command.executeCommand(request);
        request.setAttribute("setMedicines", medicines);

        if (commandName.equals("dom") || commandName.equals("sax") || commandName.equals("stax")) {
            request.getRequestDispatcher("/WEB-INF/dom.jsp").forward(request, response);
        } else {
            log.error("go to 404");
        }
    }
}
