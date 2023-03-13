import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pizzeria.PizzeriaApplication;
import pizzeria.model.Pizza;
import pizzeria.service.PizzeriaService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = PizzeriaApplication.class)
public class TestPizzeriaService {

    @Autowired
    PizzeriaService pizzeriaService;

    @Test
    public void testOrdinaPizza(){
        Pizza pizza = new Pizza();
        pizza.setPizzaName("Margherita");
        String ticket = pizzeriaService.ordinaPizza(pizza);

        assertNotNull(ticket);
    }


    /* Test get pizza quando ancora non è presa in carico
       dal pizzaiolo deve ritornate TO DO
    *
     */
    @Test
    public void testGetPizzaToDo() {
        //Effettuiamo l'ordine

        Pizza pizza = new Pizza();
        pizza.setPizzaName("Margherita");
        String ticket = pizzeriaService.ordinaPizza(pizza);

        assertEquals("TO DO",pizzeriaService.getPizza(ticket));
    }

    /*
       Effettuaiamo un test


     */
    @Test
    public void testGetPizzaPreparing() {

        /* Per Effettuare questo test mi devo assicurare di non avere nessun record nel db */
         pizzeriaService.deleteAllOrder();
        //Effettuiamo l'ordine

        Pizza pizza = new Pizza();
        pizza.setPizzaName("Margherita");
        String ticket = pizzeriaService.ordinaPizza(pizza);

        // Il pizzaiolo prende in carico l'ordine
        pizzeriaService.getPizza();

        assertEquals("PREPARING",pizzeriaService.getPizza(ticket));
    }


    /*
        Gestiamo il caso in cui effettuaimo l'ordine , il pizzaiolo prende in carico la pizza
        e la pizza è pronta , il cliente dovra trovarsi con lo stato DONE
     */

    @Test
    public void testGetPizzaDone() {
        //Effettuiamo l'ordine

        Pizza pizza = new Pizza();
        pizza.setPizzaName("Margherita");
        String ticket = pizzeriaService.ordinaPizza(pizza);

        // Il pizzaiolo prende in carico l'ordine
        pizzeriaService.getPizza();
        // il pizzaiolo incartona la pizza ed pronta , buon appetito!
        pizzeriaService.donePizza();
        assertEquals("DONE",pizzeriaService.getPizza(ticket));
    }
}
