package by.training.information_handling.service.parser;

import by.training.information_handling.bean.Component;
import by.training.information_handling.bean.Composite;
import by.training.information_handling.bean.Symbol;

import java.util.List;

public class SymbolParser extends Parser {

    @Override
    public Composite parse(String word) {
        List<Character> characterList = TextParserHelper.getCharacters(word);
        Composite symbolLeaf = new Symbol();
        for (var symbol : characterList) {
            Component component = new Symbol(symbol);
            symbolLeaf.add(component);
        }
        return symbolLeaf;
    }
}
