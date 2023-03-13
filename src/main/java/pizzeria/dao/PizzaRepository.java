package pizzeria.dao;

import pizzeria.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository {


    int insertPizza(Pizza pizza);

    int deleteAll();

    int updateStatus(Pizza pizza);

    List<Pizza> makePizza();

    List<Pizza> findPizza();

    String findByTicket(String ticket);


}
