package by.training.xml.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListMedicine {
    List<Medicine> medicines;

    public ListMedicine(List<Medicine> medicines) {
        this.medicines = new ArrayList<>();
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListMedicine that = (ListMedicine) o;
        return Objects.equals(medicines, that.medicines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicines);
    }

    @Override
    public String toString() {
        return "ListMedicine{" +
                "medicines=" + medicines +
                '}';
    }
}
