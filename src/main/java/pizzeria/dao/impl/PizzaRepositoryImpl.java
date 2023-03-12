package pizzeria.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import pizzeria.dao.PizzaRepository;
import pizzeria.dao.mapper.PizzaMapper;
import pizzeria.model.Pizza;

import java.util.List;
import java.util.Optional;

@Repository
public class PizzaRepositoryImpl implements PizzaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertPizza(Pizza pizza) {
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
    public List<Pizza> makePizza() {
        return jdbcTemplate.query("select * from pizzeria where STATUS = 'TO DO' LIMIT 1", new PizzaMapper());
    }

    @Override
    public List<Pizza> findPizza() {
        return jdbcTemplate.query(
                "SELECT * FROM PIZZERIA where STATUS = 'PREPARING'", new PizzaMapper());
    }


    @Override
    public String findByTicket(String ticket) {
        String sql = "select STATUS from pizzeria where TICKET like '?'".replace("?" , ticket);
        return jdbcTemplate.queryForObject(sql,String.class);
    }

}
