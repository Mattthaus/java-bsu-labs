package by.mathew.labs.composite;

public class Symbol implements Component {

    //Как конечный тип, не имеющий в себе компонентов ниже, выделился в отдельный класс
    //Имеет поле content, содержащее сам символ и тип определён как Символ по понятной причине
    private String content;
    private final ComponentType type = ComponentType.SYMBOL;

    public Symbol(String content){
        this.content = content;
    }

    @Override
    public String toString(){
        return content;
    }
}
