package by.training.xml.service.parser.factory;


import by.training.xml.bean.Medicine;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractBuilder {

    protected Set<Medicine> medicines;

    protected AbstractBuilder() {
        medicines = new HashSet<>();
    }

    protected AbstractBuilder(Set<Medicine> medicines) {
        this.medicines = medicines;
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public abstract void buildSetMedicines(String filename);
}

