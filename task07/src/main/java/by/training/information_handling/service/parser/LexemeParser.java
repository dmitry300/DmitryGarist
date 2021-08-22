package by.training.information_handling.service.parser;

import by.training.information_handling.bean.Composite;
import by.training.information_handling.bean.Lexeme;

import java.util.regex.Pattern;

public class LexemeParser extends Parser {
    private static final Pattern LEXEME_DELIMITER = Pattern.compile("[\\s]+");

    public LexemeParser(Parser parser) {
        super(parser);
    }

    @Override
    public Composite parse(String sentence) { //принимает композит и строку
        String[] lexemes = LEXEME_DELIMITER.split(sentence.trim());
        Composite nextComposite = new Lexeme();
        for (String lexeme : lexemes) {
            if (getNextParser() != null) {
                getNextParser().parse(lexeme);
            }
            nextComposite.add(nextComposite);
        }
        return nextComposite;
    }
}
