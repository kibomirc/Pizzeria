package pizzeria.dao;

import pizzeria.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository {


    int insertPizza(Pizza pizza,String token);

    int deleteByTicket(String ticket);

    int updateStatus(Pizza pizza);

    List<Pizza> findPizza();

    Optional<Pizza> findByTicket(String ticket);


}
