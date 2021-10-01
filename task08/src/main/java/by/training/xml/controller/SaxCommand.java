package by.training.xml.controller;

import by.training.xml.bean.Medicine;
import by.training.xml.service.parser.factory.AbstractBuilder;
import by.training.xml.service.parser.factory.MedicineBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class SaxCommand implements Command{
    @Override
    public Set<Medicine> executeCommand(HttpServletRequest httpServletRequest) {
        AbstractBuilder builder = MedicineBuilder.createMedicineBuilder("sax");
        builder.buildSetMedicines("src/main/resources/data/medicine.xml");
        return builder.getMedicines();
    }
}
