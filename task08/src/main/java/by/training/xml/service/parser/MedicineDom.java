package by.training.xml.service.parser;

import by.training.xml.bean.*;
import by.training.xml.service.parser.factory.AbstractBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MedicineDom extends AbstractBuilder {
    private static final Logger log = LogManager.getLogger(MedicineDom.class);
    private DocumentBuilder documentBuilder;

    public MedicineDom() {
        medicines = new HashSet<Medicine>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.error("ParserConfigurationException!!!");
        }
    }

    @Override
    public Set<Medicine> getMedicines() {
        return medicines;
    }

    @Override
    public void buildSetMedicines(String fileName) {
        Document document;
        try {
            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList medicinesList = root.getElementsByTagName("medicine");
            for (int i = 0; i < medicinesList.getLength(); i++) {
                Element medicineElement = (Element) medicinesList.item(i);
                Medicine medicine = buildMedicine(medicineElement);
                medicines.add(medicine);
            }
        } catch (SAXException | IOException e) {
            log.error("SAXException| IOException!!!");
        }
    }

    private Medicine buildMedicine(Element medicineElement) {
        Medicine medicine = new Medicine();
        medicine.setId(Integer.parseInt(medicineElement.getAttribute("id")));
        medicine.setName(getElementTextContent(medicineElement, "name"));
        medicine.setPharm(getElementTextContent(medicineElement, "pharm"));
        medicine.setGroup(getElementTextContent(medicineElement, "group"));
        medicine.setVersion(getElementTextContent(medicineElement, "version"));

        CertificateMedicine certificateMedicine = new CertificateMedicine();
        Element certificateElement = (Element) medicineElement.getElementsByTagName("certificate").item(0);
        certificateMedicine.setNumber(Long.parseLong(getElementTextContent(certificateElement, "number")));
        certificateMedicine.setShelfLife(getElementTextContent(certificateElement, "shelfLife"));
        certificateMedicine.setRegisteringOrganization(getElementTextContent(certificateElement, "registeringOrganization"));
        medicine.setCertificate(certificateMedicine);

        PackageMedicine packageMedicine = new PackageMedicine();
        Element packageElement = (Element) medicineElement.getElementsByTagName("package").item(0);
        packageMedicine.setAmount(Integer.parseInt(getElementTextContent(packageElement, "amount")));
        packageMedicine.setPrice(getElementTextContent(packageElement, "price"));
        packageMedicine.setType(getElementTextContent(packageElement, "type"));
        medicine.setPackageMedicine(packageMedicine);

        Dosage dosage = new Dosage();
        Element dosageElement = (Element) medicineElement.getElementsByTagName("dosage").item(0);
        dosage.setDose(getElementTextContent(dosageElement, "dose"));
        dosage.setFrequency(getElementTextContent(dosageElement, "frequency"));
        medicine.setDosage(dosage);

        List<AnalogMedicine> listAnalogs = new ArrayList<>();
        Element analogElement = (Element) medicineElement.getElementsByTagName("analogs").item(0);
        for (int i = 0; i < 3; i++) {
            AnalogMedicine analogMedicine = new AnalogMedicine();
            listAnalogs.add(analogMedicine);
        }
        int i = 0;
        for (var analog : listAnalogs) {
            analog.setAnalog(getElementTextContentAnalog(analogElement, "analog", i));
            i++;
        }
        medicine.setAnalogs(listAnalogs);
        return medicine;
    }

    // get the text content of the tag
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }

    private static String getElementTextContentAnalog(Element element, String elementName, int index) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(index);
        return node.getTextContent();
    }

}
