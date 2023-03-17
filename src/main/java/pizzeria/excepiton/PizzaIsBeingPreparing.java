package pizzeria.excepiton;

public class PizzaIsBeingPreparing extends RuntimeException {
    private static final long serialVersionUID = 1885653349235601203L; //TODO : ripetere qui

    private String message = "Pizza Error";

    public PizzaIsBeingPreparing() {
        super("Pizza Error");
    }

    public PizzaIsBeingPreparing(String message) {
        super("message :" + message);
    }
}
