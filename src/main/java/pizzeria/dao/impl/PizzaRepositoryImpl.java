package pizzeria.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pizzeria.dao.PizzaRepository;
import pizzeria.model.Pizza;

import java.util.List;
import java.util.Optional;

@Repository
public class PizzaRepositoryImpl implements PizzaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertPizza(Pizza pizza, String token) {
        return jdbcTemplate.update(
                "insert into pizzeria (ticket, pizzaName, status) values(?,?,?)",
                pizza.getTicket(), pizza.getPizzaName(), "TO DO");
    }

    @Override
    public int deleteByTicket(String ticket) {
        return jdbcTemplate.update(
                "delete pizza where ticket = ?",
                ticket);
    }

    @Override
    public int updateStatus(Pizza pizza) {
        return jdbcTemplate.update(
                "UPDATE pizzeria SET status = ? where ticket = ?",
                pizza.getStatus(),
                pizza.getTicket());
    }

    @Override
    public List<Pizza>findPizza() {
        return jdbcTemplate.query(
                "select * from pizzeria where status = \"TO DO\" LIMIT 1",
                (rs, rowNum) ->
                        new Pizza(
                                rs.getString("ticket"),
                                rs.getString("pizzaName"),
                                rs.getString("status")
                        )
        );
    }

    @Override
    public Optional<Pizza> findByTicket(String ticket) {
        return jdbcTemplate.queryForObject("select * from pizzeria where ticket like ?", Optional.class);
    }

}
