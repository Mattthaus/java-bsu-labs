package by.mathew.labs.handler;

import by.mathew.labs.composite.Component;
import by.mathew.labs.composite.Composite;
import by.mathew.labs.composite.ComponentType;
import by.mathew.labs.composite.Symbol;

public class LexemeHandler implements BaseHandler{

    //Разбивает Лексему на символы
    @Override
    public Composite handleText(String text) {
        Composite lexemeComposite = new Composite(ComponentType.LEXEME);
        for (int i = 0; i < text.length(); i++){
            String symbolString = String.valueOf(text.charAt(i));
            Component symbol = new Symbol(symbolString);
            lexemeComposite.addComponent(symbol);
        }
        return lexemeComposite;
    }
}
