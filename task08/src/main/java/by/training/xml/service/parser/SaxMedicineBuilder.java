package by.training.xml.service.parser;

import by.training.xml.bean.Medicine;
import by.training.xml.service.parser.factory.AbstractBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SaxMedicineBuilder extends AbstractBuilder {
    private final SaxHandler handler = new SaxHandler();
    private XMLReader reader;

    public SaxMedicineBuilder() {
        medicines = new HashSet<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace(); // log
        }
        reader.setErrorHandler(new SaxErrorHandler());
        reader.setContentHandler(handler);
    }

    public Set<Medicine> getMedicine() {
        return medicines;
    }

    public void buildSetMedicines(String filename) {
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
        medicines = handler.getMedicines();
    }
}
