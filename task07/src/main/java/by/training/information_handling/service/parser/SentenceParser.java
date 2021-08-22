package by.training.information_handling.service.parser;

import by.training.information_handling.bean.Composite;
import by.training.information_handling.bean.Sentence;

import java.util.regex.Pattern;

public class SentenceParser extends Parser {
    private static final Pattern SENTENCE_DELIMITER = Pattern.compile("(([^?!.(]|\\\\([^)]*\\\\))*[.?!]{1,3})");


    public SentenceParser(Parser parser) {
        super(parser);
    }

    @Override
    public Composite parse(String paragraph) {
        String[] sentences = SENTENCE_DELIMITER.split(paragraph.trim());
        Composite nextComposite = new Sentence();
        for (String sentence : sentences) {
            if (getNextParser() != null) {
                getNextParser().parse(sentence);
            }
            nextComposite.add(nextComposite);

        }

        return nextComposite;
    }
}
