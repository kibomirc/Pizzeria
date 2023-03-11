package pizzeria.model;

public class Pizza {

    private String pizzaName;

    private String ticket;

    private String status;

    public Pizza(String ticket, String pizzaName, String status) {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Pizza() {

    }

    public Pizza(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }


}
