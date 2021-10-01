package by.training.xml.controller;

import by.training.xml.service.parser.factory.AbstractBuilder;
import by.training.xml.service.parser.factory.MedicineBuilder;
import org.xml.sax.SAXException;

public class Main {
    public static void main(String[] args) throws SAXException {
//        BaseValidator baseValidator = new BaseValidator();
//        baseValidator.validate();
        String type = "stax";
        AbstractBuilder builder = MedicineBuilder.createMedicineBuilder(type);
        builder.buildSetMedicines("src/main/resources/data/medicine.xml");
        System.out.println(builder.getMedicines());
    }
}
