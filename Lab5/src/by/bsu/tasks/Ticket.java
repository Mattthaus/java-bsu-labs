package by.bsu.tasks;

public class Ticket {

    //стоимость
    private double cost;

    public Ticket()
    {
        this.cost = 0;
    }

    public Ticket(double cost)
    {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("Стоимость билета: ").append(cost);
        sb.append('$');
        return sb.toString();
    }
}
