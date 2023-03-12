package pizzeria.excepiton;

public class PizzaIsBeingPreparing extends RuntimeException {
    private static final long serialVersionUID = 1885653349235601203L; //TODO : ripetere qui

    private String message = "Garage is full";

    public PizzaIsBeingPreparing() {
        super("Garage is full");
    }

    public PizzaIsBeingPreparing(String message) {
        super("message :" + message);
    }
}
