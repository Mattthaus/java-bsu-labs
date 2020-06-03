package by.mathew.labs.reader;

//Константы с регулярками для разделения строки на нужные компоненты
public class RegularExpressionConstant {
    public static final String PARAGRAPH_REGEX = "\\s{4}";
    public static final String SENTENCE_REGEX = "(?:[^!?.]|\\.(?=\\d))+[!?.]";
    public static final String LEXEME_SPLITERATOR = "\\S+";
}
