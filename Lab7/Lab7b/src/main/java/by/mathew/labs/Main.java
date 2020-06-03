package by.mathew.labs;

import by.mathew.labs.composite.Component;
import by.mathew.labs.composite.Composite;
import by.mathew.labs.display.Display;
import by.mathew.labs.handler.LexemeHandler;
import by.mathew.labs.handler.TextHandler;
import by.mathew.labs.reader.TextReader;


import java.util.*;

public class Main {
    public static void main(String[] args){
        String text = TextReader.getTextFromPath("src/main/resources/text.txt");

        System.out.println("Got text:");
        System.out.println(text);

        Composite textComposite = new TextHandler().handleText(text);

//        Для вывода по компонентам (Раскомментировать нужное)

        Display.displayParagraphs(textComposite);

//        Display.displaySentences(textComposite);

//        Display.displayLexemes(textComposite);

//        Display.displaySymbols(textComposite);

//      7b  В некотором предложении текста слова заданной длины заменить указанной подстрокой,
//        длина которой может не совпадать с длиной слова.

        taskSevenB(textComposite, 5,3, "lalalala");
        System.out.println(textComposite);

//       7c Текст шифруется по следующему правилу: из исходного текста выбирается
//        1, 4, 7, 10-й и т. д. (до конца текста) символы, затем 2, 5, 8, 11-й и т. д. (до
//        конца текста) символы, затем 3, 6, 9, 12-й и т. д. Зашифровать заданный текст
        textComposite = taskSevenC(textComposite);
        System.out.println("\nNew Text:");
        System.out.println(textComposite);
    }


    //Функция по 7b
    public static void taskSevenB(Composite textComposite, int sentenceNumber, int triggerLength, String substring){
        int currentSentenceNumber = 0;

        //Чтобы менять прям внутри имеющегося текста, ведём подсчёт предложений в отдельной переменной
        //Когда натыкаемся на нужный номер, вызывается функция, меняющая подстроки заданной длины новой подстрокой
        ArrayList<Component> paragraphs = textComposite.getComponents(); //Получаем компоненты ещё более низкого порядка для обработки
        for (int i = 0; i < paragraphs.size(); i++){
            ArrayList<Component> sentences = ((Composite) paragraphs.get(i)).getComponents(); //Получаем компоненты ещё более низкого порядка для обработки
            for (int j = 0; j < sentences.size(); j++){
                if (currentSentenceNumber == sentenceNumber){
                    replaceByLength(((Composite) sentences.get(j)), triggerLength, substring);
                }
                currentSentenceNumber++;
            }
        }
    }

    public static void replaceByLength(Composite sentence, int triggerLength, String substring){
        ArrayList<Component> lexemes = sentence.getComponents();
        // Объявление сначала паттерна, потом матчера, и все эти приколы считаю здесь
        // нецелесообразным - куда легче написать весь алфавит в строку и просто проверять через .contains()
        String allLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < lexemes.size(); i++){
            if (lexemes.get(i).toString().length() == triggerLength) {
                lexemes.set(i, new LexemeHandler().handleText(substring));
            }
            else {
                //для случая если есть знак препинания - лексема его подцепляет как свою составную часть
                String lexemeStr = lexemes.get(i).toString();
                String lastSign = String.valueOf(lexemeStr.charAt(lexemeStr.length()-1));
                if ((lexemeStr.length() - 1 == triggerLength) && !(allLetters.contains(lastSign))){
                    lexemes.set(i, new LexemeHandler().handleText(substring + lastSign));
                }
            }
        }
    }


    //Функция по 7c
    public static Composite taskSevenC(Composite textComposite){
        //Получаем список символов текста
        List<String> symbols = Arrays.asList(textComposite.toString().split(""));

        StringBuilder sb = new StringBuilder("");
        //Во внешнем цикле мы организуем начальную точку, чтобы сначала добавлялись 1,4,7...,
        //Потом 2,5,8... и 3,6,9... соответственно. Во внутреннем проходим по каждому третьему, начав с 1, 2 или 3-го
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < symbols.size()-i; j+=3){
                sb.append(symbols.get(i+j));
            }
        }

        //Составляем новый текст, предварительно разбив на части
        textComposite = new TextHandler().handleText(sb.toString());
        return textComposite;
    }

}
