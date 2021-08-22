package by.training.information_handling.service.parser;

import by.training.information_handling.bean.Composite;
import by.training.information_handling.bean.Paragraph;

import java.util.regex.Pattern;

public class ParagraphParser extends Parser {
    private static final Pattern PARAGRAPH_DELIMITER = Pattern.compile("[^\\n\\t]+");

    public ParagraphParser(Parser parser) {
        super(parser);
    }

    @Override
    public Composite parse(String text) {
        String[] paragraphs = PARAGRAPH_DELIMITER.split(text.trim());
        Composite compositeParagraph = new Paragraph();
        for (String paragraph : paragraphs) {
            if(getNextParser()!=null) {
                getNextParser().parse(paragraph);
            }
            compositeParagraph.add(compositeParagraph);


        }
        return compositeParagraph;
    }
}
