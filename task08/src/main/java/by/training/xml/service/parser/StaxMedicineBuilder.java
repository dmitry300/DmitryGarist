package by.training.xml.service.parser;

import by.training.xml.bean.*;
import by.training.xml.service.parser.factory.AbstractBuilder;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StaxMedicineBuilder extends AbstractBuilder {
    private final XMLInputFactory inputFactory;

    public StaxMedicineBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        medicines = new HashSet<>();
    }

    @Override
    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void buildSetMedicines(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            reader = inputFactory.createXMLStreamReader(inputStream);
// StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(MedicineXmlTag.MEDICINE.getValue())) {
                        Medicine medicine = buildMedicine(reader);
                        medicines.add(medicine);
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    private Medicine buildMedicine(XMLStreamReader reader) throws XMLStreamException {
        Medicine medicine = new Medicine();
        medicine.setId(Integer.parseInt(reader.getAttributeValue(null, MedicineXmlTag.ID.getValue())));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase())) {
                        case NAME -> medicine.setName(getXMLText(reader));
                        case PHARM -> medicine.setPharm(getXMLText(reader));
                        case GROUP -> medicine.setGroup(getXMLText(reader));
                        case ANALOGS -> medicine.setAnalogs(getXMLAnalogs(reader));
                        case VERSION -> medicine.setVersion(getXMLText(reader));
                        case CERTIFICATE -> medicine.setCertificate(getXMLCertificate(reader));
                        case PACKAGE -> medicine.setPackageMedicine(getXMLPackage(reader));
                        case DOSAGE -> medicine.setDosage(getXMLDosage(reader));
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.MEDICINE) {
                        return medicine;
                    }
                    break;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag <medicine>");
    }

    private CertificateMedicine getXMLCertificate(XMLStreamReader reader) throws XMLStreamException {
        CertificateMedicine certificateMedicine = new CertificateMedicine();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase())) {
                        case NUMBER -> certificateMedicine.setNumber(Integer.parseInt(getXMLText(reader)));
                        case SHELFLIFE -> certificateMedicine.setShelfLife(getXMLText(reader));
                        case REGISTERINGORGANIZATION -> certificateMedicine.setRegisteringOrganization(getXMLText(reader));
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.CERTIFICATE) {
                        return certificateMedicine;
                    }
                    break;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag <certificate>");
    }

    private PackageMedicine getXMLPackage(XMLStreamReader reader) throws XMLStreamException {
        PackageMedicine packageMedicine = new PackageMedicine();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase())) {
                        case TYPE -> packageMedicine.setType(getXMLText(reader));
                        case AMOUNT -> packageMedicine.setAmount(Integer.parseInt(getXMLText(reader)));
                        case PRICE -> packageMedicine.setPrice(getXMLText(reader));
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.PACKAGE) {
                        return packageMedicine;
                    }
                    break;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag <package>");
    }

    private List<AnalogMedicine> getXMLAnalogs(XMLStreamReader reader) throws XMLStreamException {
        List<AnalogMedicine> listAnalogs = new ArrayList<>();
        int type;
        String name;
        AnalogMedicine analogMedicine;
        for (int i = 0; i < 3; i++) {
            analogMedicine = new AnalogMedicine();
            listAnalogs.add(analogMedicine);
        }
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.ANALOG) {
                        listAnalogs.get(0).setAnalog(getXMLText(reader));
                        if (reader.hasNext()) {
                            String text;
                            text = reader.getText();
                            listAnalogs.get(1).setAnalog(text);
                        }
                        if (reader.hasNext()) {
                            String text;
                            text = reader.getText();
                            listAnalogs.get(2).setAnalog(text);
                        }

                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.ANALOGS) {
                        return listAnalogs;
                    }
                    break;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag <analogs>");
    }

    private Dosage getXMLDosage(XMLStreamReader reader) throws XMLStreamException {
        Dosage dosage = new Dosage();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase())) {
                        case DOSE -> dosage.setDose(getXMLText(reader));
                        case FREQUENCY -> dosage.setFrequency(getXMLText(reader));
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.DOSAGE) {
                        return dosage;
                    }
                    break;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag <dosage>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}

