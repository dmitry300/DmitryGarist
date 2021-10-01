package by.training.xml.service.parser;

public enum MedicineXmlTag {
    NAME("name"), PHARM("pharm"), GROUP("group"),
    NUMBER("number"), SHELFLIFE("shelfLife"),
    REGISTERINGORGANIZATION("registeringOrganization"), TYPE("type"),
    AMOUNT("amount"), PRICE("price"), DOSE("dose"),
    FREQUENCY("frequency"), VERSION("version"), MEDICINE("medicine"), ID("id"),
    CERTIFICATE("certificate"), ANALOGS("analogs"),ANALOG("analog") ,PACKAGE("package"),
    DOSAGE("dosage");

    private final String value;

    MedicineXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
