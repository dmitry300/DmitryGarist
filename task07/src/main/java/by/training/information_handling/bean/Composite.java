package by.training.information_handling.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class Composite implements Component {
    private final List<Component> components;

    protected Composite() {
        this.components = new ArrayList<>();
    }

    public List<Component> getComponents() {
        return components;
    }

    public void add(Component component) throws UnsupportedOperationException {
        components.add(component);
    }

    public void remove(Component component) throws UnsupportedOperationException {
        components.remove(component);
    }

    public Component getChild(int index) {
        return components.get(index);
    }

    public abstract String collect();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
//    public String toString() {
//        StringBuilder stringJoiner = new StringBuilder();
//        for (Component textComponent : components) {
//            stringJoiner.append(textComponent.toString());
//        }
//        return stringJoiner.toString();
//    }
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Component component : getComponents()) {
            str.append(component.collect());
        }
        return str.toString();
    }
}
