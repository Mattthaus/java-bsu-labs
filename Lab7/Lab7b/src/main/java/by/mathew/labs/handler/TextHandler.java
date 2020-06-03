package by.mathew.labs.handler;

import by.mathew.labs.composite.Composite;
import by.mathew.labs.composite.ComponentType;
import by.mathew.labs.reader.RegularExpressionConstant;

public class TextHandler implements BaseHandler{

    //Разбивает Текст на Параграфы. Для н
    @Override
    public Composite handleText(String text) {
        Composite textComposite = new Composite(ComponentType.TEXT);
        String[] paragraphs = text.split(RegularExpressionConstant.PARAGRAPH_REGEX);

        // По цепочке разбивает каждый параграф на предложения,
        // так что можно из текста вытянуть параграфы, а из них в свою очередь предложения и т.д.
        for (String paragraph: paragraphs){
            textComposite.addComponent(new ParagraphHandler().handleText(paragraph));
        }
        return textComposite;
    }
}
