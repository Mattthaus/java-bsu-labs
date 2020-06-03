package by.mathew.labs.composite;

import java.util.ArrayList;

public class Composite implements Component{
    //Имеет тип данного компонента и список компонентов порядком ниже (Тип Текст - список Параграф и т.п.)

    private ComponentType type;
    private ArrayList<Component> components;


    //Конструктор по типу создаваемого компонента
    public Composite(ComponentType type){
        this.type = type;
        components = new ArrayList<>();
    }


    //Получить тип компонента
    public ComponentType getType() {
        return type;
    }


    //Получить список компонентов внутри данного
    public ArrayList<Component> getComponents() {
        return components;
    }

    //Добавить компонент
    public boolean addComponent(Component component){return components.add(component);}

    //Формируется текст из имеющегося компонента
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        String result = "";
        switch (type){
            //Для текста склеиваем абзацы
            case TEXT:
                for (Component component : components){
                    sb.append(component).append("\n\t");
                }
                result = sb.toString().trim();
                break;
            //Для лексемы склеиваем символы
            case LEXEME:
                for (Component component : components){
                    sb.append(component.toString());
                }
                result = sb.toString();
                break;
            //Для Абзаца склеиваем между собой Предложения, перенося каждое на новую строчку
            case PARAGRAPH:
                for (Component component : components){
                    sb.append(component).append("\n");
                }
                result = sb.toString().trim();
                break;
            //Для Предложения склеиваем Лексемы, разделяя пробелом
            default:
                for (Component component: components){
                    sb.append(component).append(" ");
                }
                result = sb.toString().trim();
        }
        return result;
    }
}
