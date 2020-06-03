package by.bsu.tasks;

import java.util.ArrayList;

//класс парк аттракционов
public class Park {

    //массив объектов внутреннего класса аттракционов
    private ArrayList<Attraction> attractions = new ArrayList<>();

    //конструктор по умолчанию
    public Park() {

    }

    //метод возвращающий массив аттракционов
    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    //внутренний класс аттракционов
    public static class Attraction
    {
        //название
        private String name;
        //время работы
        private String workingTime;
        private Ticket ticket;

        //конструктор по умолчанию
        public Attraction() {
            this.name = "";
            this.workingTime = "";
            this.ticket = new Ticket(0);
        }

        //конструктор с параметрами
        public Attraction(String name, String workingTime, double cost) {
            this.name = name;
            this.workingTime = workingTime;
            this.ticket = new Ticket(cost);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWorkingTime() {
            return workingTime;
        }

        public void setWorkingTime(String workingTime) {
            this.workingTime = workingTime;
        }

        public Ticket getTicket() {
            return ticket;
        }

        public void setTicket(Ticket ticket) {
            this.ticket = ticket;
        }

        //перегрузка метода toString для аттракциона
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("");
            sb.append("Название: ").append(name).append('\n');
            sb.append("Время работы аттракциона: ").append(workingTime).append('\n');
            sb.append(ticket.toString());
            sb.append('\n');
            return sb.toString();
        }
    }

    //перегрузка метода toString для парка аттракционов
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Парк аттракционов:\n");
        for (int i = 0; i < attractions.size(); i++) {
            sb.append("Аттракцион №").append(i+1).append('\n');
            sb.append(attractions.get(i));
        }
        return sb.toString();
    }
}
