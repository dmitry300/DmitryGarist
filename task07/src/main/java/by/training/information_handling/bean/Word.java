package by.training.information_handling.bean;

import java.util.ArrayList;
import java.util.List;

public class Word extends Composite {
    private List<Component> symbols = new ArrayList<>();

    @Override
    public void add(Component component) {
        symbols.add(component);
    }

    @Override
    public void remove(Component component) {
        symbols.remove(component);
    }

    @Override
    public String collect() {
        String str = null;
        for (Component component : getComponents()) {
            str += component.collect();
        }
        return str;
    }
}
