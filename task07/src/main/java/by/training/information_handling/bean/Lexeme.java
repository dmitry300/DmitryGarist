package by.training.information_handling.bean;

public class Lexeme extends Composite {

    public Lexeme() {
        super();
    }

    @Override
    public String collect() {
        StringBuilder str = new StringBuilder();
        for (Component component : getComponents()) {
            str.append(component.collect());
        }
        return str.toString();
    }
}
