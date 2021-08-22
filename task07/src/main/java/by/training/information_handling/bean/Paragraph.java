package by.training.information_handling.bean;

public class Paragraph extends Composite {

    public Paragraph() {
        super();
    }

    @Override
    public String collect() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : getComponents()) {
            stringBuilder.append(component);
        }
        return stringBuilder.toString();
    }
}
