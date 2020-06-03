package by.mathew.labs;

import by.mathew.labs.exception.FileReadException;
import by.mathew.labs.reader.TextReader;

import java.util.*;

// В стихотворении найти одинаковые буквы, которые встречаются во всех словах.

public class Main {

    public static void main(String[] args) throws FileReadException {
        String text = TextReader.parseText("src/main/resources/lab_text.txt");

        String[] wordsArray = text.split("[^А-Яа-я]+");

        System.out.println("Got words:");
        System.out.println(Arrays.asList(wordsArray));

        //В стихотворении найти одинаковые буквы, которые встречаются во всех словах
        //Идея следующая: получаем список всех слов, и поначалу считаем, что все символы первого слова встречаются
        //Записываем Массив из элементов первого слова
        //Далее пробегаем по каждому слову, отсеивая из начального списка те символы, что не встретились в очередном слове
        //В примере слова с общими буквами 'г', 'р', 'и', чтобы продемонстрировать, что находятся больше 1-й общей
        List<String> commonCharsList = Arrays.asList(wordsArray[0].toLowerCase().split(""));
        Set<String> set = new HashSet<>(commonCharsList);
        commonCharsList = new ArrayList<>();
        commonCharsList.addAll(set);
        List<String> previousCommonCharsList;
        //Пробегаем по каждому слову, внутри проверяя каждый символ из commonCharsList
        // на предмет нахождения его в этой лексеме
        for (String word: wordsArray){
            //Сохраняем прошлый список символов
            previousCommonCharsList = new ArrayList<>(commonCharsList);
            //Чистим имеющийся, чтобы потом занести в него только оставшиеся значения
            commonCharsList = new ArrayList<>();
            for (String symbol: previousCommonCharsList){
                if (word.toLowerCase().contains(symbol)){
                    commonCharsList.add(symbol);
                }
            }
        }
        System.out.println("Common symbols for all words:");
        System.out.println(commonCharsList);

    }
}
