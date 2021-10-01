package by.training.xml.service.parser.validator;

import by.training.xml.service.parser.SaxErrorHandler;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class BaseValidator {

    public void validate() throws SAXException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "scr/main/resources/data/medicine.xml";
        String schemaName = "scr/main/resources/data/medicine.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
// schema creation
            Schema schema = factory.newSchema(schemaLocation);
// creating a schema-based validator
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
// document check
            validator.setErrorHandler(new SaxErrorHandler());
            validator.validate(source);
        } catch (DOMException | IOException | SAXException  e) {
            new SaxErrorHandler().error((SAXParseException) e);
            System.err.println(fileName + " is not correct or valid");
        }
    }
}

