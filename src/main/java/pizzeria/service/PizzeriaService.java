package pizzeria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pizzeria.dao.PizzaRepository;
import pizzeria.excepiton.PizzaIsBeingPreparing;
import pizzeria.model.Pizza;
import pizzeria.utils.TicketUtils;

import java.util.List;

@Service
@Configurable
public class PizzeriaService {

    private final String DONE = "DONE";
    private final String PREPARING = "PREPARING";

    @Autowired
    PizzaRepository pizzaRepository;

    public PizzeriaService() {

    }

    // Service Cliente

    public String ordinaPizza(Pizza pizza) {
          // genera ticket impletare la classe utils
          pizza.setTicket(TicketUtils.ticketGenerator());
          pizzaRepository.insertPizza(pizza);

          return pizza.getTicket();

    }

    public String getPizza(String ticket) {
        try {
            return pizzaRepository.findByTicket(ticket);
        }catch(EmptyResultDataAccessException e) {
            return "TICKET NON VALIDO!";
        }
    }

    // Service Pizzaiolo

    public void getPizza() {
        // Controllare se ci sono altre pizze in lavorazione
        List<Pizza> pizza = pizzaRepository.findPizza();
        if(pizza.size() == 0) {
            // Non ci sono pizze in preparazione
            pizza = pizzaRepository.makePizza();
            pizza.get(0).setStatus(PREPARING);

            pizzaRepository.updateStatus(pizza.get(0));
        } else {
            throw new PizzaIsBeingPreparing("Pizza is being Preparing");
        }

    }

    public void donePizza() {
        // prendo la pizza che ho in preparazioen
        List<Pizza> pizza = pizzaRepository.findPizza();
        // aggiorno lo status in DONE
        if(pizza.size() > 0) {
            pizza.get(0).setStatus(DONE);
            pizzaRepository.updateStatus(pizza.get(0));
        }
    }

    public void deleteAllOrder() {
        pizzaRepository.deleteAll();
    }
}
