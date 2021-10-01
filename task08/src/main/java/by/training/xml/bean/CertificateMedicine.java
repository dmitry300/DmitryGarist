package by.training.xml.bean;


import java.util.Objects;

public class CertificateMedicine {
    private long number;
    private String shelfLife;
    private String registeringOrganization;

    public CertificateMedicine() {

    }

    public CertificateMedicine(long number, String shelfLife, String registeringOrganization) {
        this.number = number;
        this.shelfLife = shelfLife;
        this.registeringOrganization = registeringOrganization;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getRegisteringOrganization() {
        return registeringOrganization;
    }

    public void setRegisteringOrganization(String registeringOrganization) {
        this.registeringOrganization = registeringOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateMedicine that = (CertificateMedicine) o;
        return number == that.number && shelfLife == that.shelfLife && Objects.equals(registeringOrganization, that.registeringOrganization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, shelfLife, registeringOrganization);
    }

    @Override
    public String toString() {
        return "CertificateMedicine{" +
                "number=" + number +
                ", shelfLife=" + shelfLife +
                ", registeringOrganization='" + registeringOrganization + '\'' +
                '}';
    }
}
