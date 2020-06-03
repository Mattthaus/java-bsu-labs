package by.mathew.labs.parse;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private TextParser() {
    }

    public static ArrayList<String> parseText(String text, String regex) {
        ArrayList<String> list = new ArrayList<>();

        if (text == null || regex == null) {
            return list;
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            // Все подряд идущие пробельные символы заменяет пробелом, начальные и конечные пробелы отсекает
            list.add(m.group().replaceAll("\\s+", " ").trim());
        }
        return list;
    }
}
