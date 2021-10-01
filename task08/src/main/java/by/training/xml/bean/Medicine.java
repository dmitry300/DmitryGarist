package by.training.xml.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Medicine {
    private int id;
    private String name;
    private String pharm;
    private String group;
    private List<AnalogMedicine> analogs;
    private String version;
    private CertificateMedicine certificate;
    private PackageMedicine packageMedicine;
    private Dosage dosage;

    public Medicine(){
        analogs = new ArrayList<>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<AnalogMedicine> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(List<AnalogMedicine> analogs) {
        this.analogs = analogs;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String  version) {
        this.version = version;
    }

    public CertificateMedicine getCertificate() {
        return certificate;
    }

    public void setCertificate(CertificateMedicine certificate) {
        this.certificate = certificate;
    }

    public PackageMedicine getPackageMedicine() {
        return packageMedicine;
    }

    public void setPackageMedicine(PackageMedicine packageMedicine) {
        this.packageMedicine = packageMedicine;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(name, medicine.name) && Objects.equals(pharm, medicine.pharm) && Objects.equals(group, medicine.group) && Objects.equals(analogs, medicine.analogs) && Objects.equals(version, medicine.version) && Objects.equals(certificate, medicine.certificate) && Objects.equals(packageMedicine, medicine.packageMedicine) && Objects.equals(dosage, medicine.dosage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pharm, group, analogs, version, certificate, packageMedicine, dosage);
    }

    @Override
    public String toString() {
        return "\nMedicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pharm='" + pharm + '\'' +
                ", group='" + group + '\'' +
                ", analogs=" + analogs +
                ", version='" + version + '\'' +
                ", certificate=" + certificate +
                ", packageMedicine=" + packageMedicine +
                ", dosage=" + dosage +
                '}';
    }
}
