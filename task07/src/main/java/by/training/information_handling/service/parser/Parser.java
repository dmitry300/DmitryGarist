package by.training.information_handling.service.parser;

import by.training.information_handling.bean.Composite;

public abstract class Parser {
    private Parser nextParser;

    protected Parser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    protected Parser() {

    }

    public Parser getNextParser() {
        return nextParser;
    }

    public abstract Composite parse(String text);

}
