package by.mathew.labs.handler;

import by.mathew.labs.composite.ComponentType;
import by.mathew.labs.composite.Composite;
import by.mathew.labs.parse.TextParser;
import by.mathew.labs.reader.RegularExpressionConstant;

import java.util.ArrayList;

public class ParagraphHandler implements BaseHandler{


    //Разбивает Параграфы на Предложения
    @Override
    public Composite handleText(String text) {
        Composite paragraphComposite = new Composite(ComponentType.PARAGRAPH);
        ArrayList<String> sentences = TextParser.parseText(text, RegularExpressionConstant.SENTENCE_REGEX);

        //По цепочке разбивает Предложения на Лексемы
        for (String sentence: sentences){
            paragraphComposite.addComponent(new SentenceHandler().handleText(sentence));
        }
        return paragraphComposite;
    }
}
