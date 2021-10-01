package by.training.xml.service.parser;

import by.training.xml.bean.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class SaxHandler extends DefaultHandler {
    private final Set<Medicine> medicines;
    private Medicine current;
    private MedicineXmlTag currentXmlTag;
    private final EnumSet<MedicineXmlTag> withText;
    private static final Logger logger = LogManager.getLogger(SaxHandler.class);

    public SaxHandler() {
        medicines = new HashSet<>();
        withText = EnumSet.range(MedicineXmlTag.NAME, MedicineXmlTag.FREQUENCY);
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (MedicineXmlTag.MEDICINE.getValue().equals(qName)) {
            current = new Medicine();
            current.setId(Integer.parseInt(attrs.getValue(0)));
        } else {
            try {
                MedicineXmlTag temp = MedicineXmlTag.valueOf(qName.toUpperCase());
                if (withText.contains(temp)) {
                    currentXmlTag = temp;
                }
            } catch (IllegalArgumentException e) {
                logger.error("Error valueOf enum constant!");
            }

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (MedicineXmlTag.MEDICINE.getValue().equals(qName)) {
            medicines.add(current);
            current = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case NAME -> current.setName(data);
                case PHARM -> current.setPharm(data);
                case GROUP -> current.setGroup(data);
                case ANALOG -> {
                    current.setAnalogs(new ArrayList<>());
                    for (int i = 0; i < 3; i++) {
                        AnalogMedicine analogMedicine = new AnalogMedicine();
                        current.getAnalogs().add(analogMedicine);
                    }
                    for (var analog : current.getAnalogs()) {
                        analog.setAnalog(data);
                    }
                }
                case VERSION -> current.setVersion(data);
                case NUMBER -> {
                    current.setCertificate(new CertificateMedicine());
                    current.getCertificate().setNumber(Long.parseLong(data));
                }
                case SHELFLIFE -> current.getCertificate().setShelfLife(data);
                case REGISTERINGORGANIZATION -> current.getCertificate().setRegisteringOrganization(data);
                case TYPE -> {
                    current.setPackageMedicine(new PackageMedicine());
                    current.getPackageMedicine().setType(data);
                }
                case AMOUNT -> current.getPackageMedicine().setAmount(Integer.parseInt(data));
                case PRICE -> current.getPackageMedicine().setPrice(data);
                case DOSE -> {
                    current.setDosage(new Dosage());
                    current.getDosage().setDose(data);
                }
                case FREQUENCY -> current.getDosage().setFrequency(data);
                default -> throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}
