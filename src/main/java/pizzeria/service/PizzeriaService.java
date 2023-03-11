package pizzeria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import pizzeria.dao.PizzaRepository;
import pizzeria.model.Pizza;

import java.util.List;
import java.util.Optional;

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
          pizza.setTicket("AA345ZZ"); // qui l'ho cablata
          pizzaRepository.insertPizza(pizza);

          return pizza.getTicket();

    }

    public String getPizza(String ticket) {
        return pizzaRepository.findByTicket(ticket).get(0).getTicket();
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
            // Lancia Eccezione
        }

    }

    public void donePizza() {
        // prendo la pizza che ho in preparazioen
        List<Pizza> pizza = pizzaRepository.findPizza();
        // aggiorno lo status in DONE
        pizza.get(0).setStatus(DONE);
        pizzaRepository.updateStatus(pizza.get(0));

    }
}
