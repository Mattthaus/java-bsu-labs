package by.mathew.labs.handler;

import by.mathew.labs.composite.Composite;


//Интерфейс обработчика компонента, делит полученный текст на компоненты низшего порядка
public interface BaseHandler {
    Composite handleText(String text);
}
