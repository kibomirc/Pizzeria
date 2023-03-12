package pizzeria.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import pizzeria.model.Pizza;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PizzaMapper implements RowMapper<Pizza> {


    public Pizza mapRow(ResultSet resultSet, int i) throws SQLException {

        Pizza pizza = new Pizza();
        pizza.setId(resultSet.getLong("id"));
        pizza.setPizzaName(resultSet.getString("pizzaname"));
        pizza.setStatus(resultSet.getString("status"));
        pizza.setTicket(resultSet.getString("ticket"));
        return pizza;
    }
}
