package by.training.xml.controller;

import by.training.xml.bean.Medicine;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public interface Command {
    Set<Medicine> executeCommand(HttpServletRequest httpServletRequest);
}
