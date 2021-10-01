package by.training.xml.bean;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AllMedicine {
    Set<Medicine> medicines;

    public AllMedicine() {
        medicines = new HashSet<>();
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(Set<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllMedicine that = (AllMedicine) o;
        return Objects.equals(medicines, that.medicines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicines);
    }

    @Override
    public String toString() {
        return "AllMedicine{" +
                "medicines=" + medicines +
                '}';
    }
}
