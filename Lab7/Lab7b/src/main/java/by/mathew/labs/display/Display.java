package by.mathew.labs.display;

import by.mathew.labs.composite.Component;
import by.mathew.labs.composite.Composite;

import java.util.ArrayList;


//Класс для вывода текста по компонентам
public class Display {

    //Параграфы
    public static void displayParagraphs(Composite textComposite){
        System.out.println("Displaying Paragraphs:");
        ArrayList<Component> paragraphs = textComposite.getComponents(); //Получаем компоненты ещё более низкого порядка для обработки
        paragraphs.forEach(paragraph ->{
            System.out.println("==========");
            System.out.println(paragraph);
            System.out.println("==========");
        });
    }

    //Предложения
    public static void displaySentences(Composite textComposite){
        System.out.println("Displaying Sentences:");

        ArrayList<Component> paragraphs = textComposite.getComponents(); //Получаем компоненты ещё более низкого порядка для обработки
        for (int i = 0; i < paragraphs.size(); i++){
            ((Composite) paragraphs.get(i)).getComponents().forEach(sentence -> {
                System.out.println("---------------");
                System.out.println(sentence);
                System.out.println("---------------");
            });
        }
    }

    //Лексемы
    public static void displayLexemes(Composite textComposite){
        System.out.println("Displaying Lexemes:");

        ArrayList<Component> paragraphs = textComposite.getComponents(); //Получаем компоненты ещё более низкого порядка для обработки
        for (int i = 0; i < paragraphs.size(); i++){
            ArrayList<Component> sentences = ((Composite) paragraphs.get(i)).getComponents(); //Получаем компоненты ещё более низкого порядка для обработки
            for (int j = 0; j < sentences.size(); j++){
                ((Composite) sentences.get(j)).getComponents().forEach(lexeme ->{
                    System.out.println("--------");
                    System.out.println(lexeme);
                    System.out.println("--------");
                });
            }
        }
    }

    //Символы
    public static void displaySymbols(Composite textComposite){
        System.out.println("Displaying Symbols:");

        ArrayList<Component> paragraphs = textComposite.getComponents(); //Получаем компоненты ещё более низкого порядка для обработки
        for (int i = 0; i < paragraphs.size(); i++){
            ArrayList<Component> sentences = ((Composite) paragraphs.get(i)).getComponents(); //Получаем компоненты ещё более низкого порядка для обработки
            for (int j = 0; j < sentences.size(); j++){
                ArrayList<Component> lexemes = ((Composite) sentences.get(j)).getComponents(); //Получаем компоненты ещё более низкого порядка для обработки
                for (int k = 0; k < lexemes.size(); k++){
                    ((Composite) lexemes.get(k)).getComponents().forEach(symbol ->{
                        System.out.println("----");
                        System.out.println(symbol);
                        System.out.println("----");
                    });
                }
            }
        }
    }
}
