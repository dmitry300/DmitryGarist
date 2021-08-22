package by.training.information_handling.service.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParserHelper {
    private static final String CHARACTER_REGEX = "\\S";

    public static List<Character> getCharacters(String data) {
        Pattern pattern = Pattern.compile(CHARACTER_REGEX);
        Matcher matcher = pattern.matcher(data);
        List<Character> result = new ArrayList<>();
        while (matcher.find()) {
            char element = matcher.group().charAt(0);
            result.add(element);
        }
        return result;
    }
}
