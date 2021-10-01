package by.training.xml.controller;

import by.training.xml.bean.Medicine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

public class WrongCommand implements Command{
    private static final Logger log = LogManager.getLogger(WrongCommand.class);
    @Override
    public Set<Medicine> executeCommand(HttpServletRequest httpServletRequest) {
        return new HashSet<>();
    }
}
