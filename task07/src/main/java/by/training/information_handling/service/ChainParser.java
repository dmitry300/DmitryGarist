package by.training.information_handling.service;

import by.training.information_handling.bean.Composite;
import by.training.information_handling.bean.Text;
import by.training.information_handling.service.parser.*;

public class ChainParser {
//    private Text composite;
//
//    public ChainParser(){}
//    public ChainParser(Text composite) {
//        this.composite = composite;
//    }

    public Composite parse(String text) {
      // composite = new Text();
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        return paragraphParser.parse(text);
    }

//    public String collectText() {
//        return composite.collect();
//    }
}
