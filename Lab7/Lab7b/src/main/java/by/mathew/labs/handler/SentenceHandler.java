package by.mathew.labs.handler;

import by.mathew.labs.composite.ComponentType;
import by.mathew.labs.composite.Composite;
import by.mathew.labs.parse.TextParser;
import by.mathew.labs.reader.RegularExpressionConstant;

import java.util.ArrayList;

public class SentenceHandler implements BaseHandler{

    //Разбивает Предложение на Лексемы
    @Override
    public Composite handleText(String text) {
        Composite sentenceComposite = new Composite(ComponentType.SENTENCE);
        ArrayList<String> lexemes = TextParser.parseText(text, RegularExpressionConstant.LEXEME_SPLITERATOR);
        for(String lexeme: lexemes){
            sentenceComposite.addComponent(new LexemeHandler().handleText(lexeme));
        }
        return sentenceComposite;
    }
}
