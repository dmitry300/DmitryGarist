package by.training.information_handling.service.parser;

import by.training.information_handling.bean.Composite;
import by.training.information_handling.bean.Word;

import java.util.regex.Pattern;

public class WordParser extends Parser {
    private static final Pattern WORD_DELIMITER = Pattern.compile("\\s+");

    public WordParser(Parser parser) {
        super(parser);
    }

    @Override
    public Composite parse(String lexem) {
        String[] words = WORD_DELIMITER.split(lexem.trim());
        Composite nextComposite = new Word();
        for (String word : words) {
            if (getNextParser() != null) {
                getNextParser().parse(word);
            }
            nextComposite.add(nextComposite);

        }
        return nextComposite;
    }
}
