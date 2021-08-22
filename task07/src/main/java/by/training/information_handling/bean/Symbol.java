package by.training.information_handling.bean;

public class Symbol extends Composite {
    private char symbol;

    public Symbol() {
    }

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String collect() {
        return String.valueOf(symbol);
    }
}
