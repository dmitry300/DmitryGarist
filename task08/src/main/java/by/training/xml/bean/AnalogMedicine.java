package by.training.xml.bean;

import java.util.Objects;

public class AnalogMedicine {
    private String analog;

    public AnalogMedicine(){

    }
    public AnalogMedicine(String analog) {
        this.analog = analog;
    }

    public String getAnalog() {
        return analog;
    }

    public void setAnalog(String analog) {
        this.analog = analog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalogMedicine that = (AnalogMedicine) o;
        return Objects.equals(analog, that.analog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(analog);
    }

    @Override
    public String toString() {
        return "AnalogMedicine{" +
                "analog='" + analog + '\'' +
                '}';
    }
}
