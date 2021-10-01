package by.training.xml.controller;

import by.training.xml.bean.Medicine;
import by.training.xml.service.parser.factory.AbstractBuilder;
import by.training.xml.service.parser.factory.MedicineBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class StaxCommand implements Command{
    @Override
    public Set<Medicine> executeCommand(HttpServletRequest httpServletRequest) {
        AbstractBuilder builder = MedicineBuilder.createMedicineBuilder("stax");
        builder.buildSetMedicines("src/main/resources/data/medicine.xml");
        return builder.getMedicines();
    }
}
