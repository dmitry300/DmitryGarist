package by.training.xml.service.parser.factory;


import by.training.xml.service.parser.MedicineDom;
import by.training.xml.service.parser.SaxMedicineBuilder;
import by.training.xml.service.parser.StaxMedicineBuilder;

public class MedicineBuilder {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    public static AbstractBuilder createMedicineBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new MedicineDom();
            }
            case STAX -> {
                return new StaxMedicineBuilder();
            }
            case SAX -> {
                return new SaxMedicineBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
}
