package pizzeria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pizzeria.model.Pizza;

@RestController
public class ControllerPizzaiolo {

    // Qui verrà inniettato il service


    // prende la prima pizza dal database con status TODO e la lavora
    @GetMapping("/pizzaiolo/makePizza")
    public ResponseEntity getPizza() {

        /*
           Chiamo service vedere lo status delle pizza
           se non c'è una pizza in lavorazione ("PREPARING")
           prendi la priam che ha lo status ("TO DO")


         */
        return ResponseEntity.status(HttpStatus.OK).build();

    }



    @GetMapping("/pizzaiolo/donePizza")
    public ResponseEntity infornaPizza() {
        //ObjectMapper objectMapper = new ObjectMapper();
        //Pizza pizzaObj = objectMapper.convertValue(pizza,Pizza.class);

        /*
           Prende lo status della pizza che sta in "PREPARING" ( ce ne sarà solo una )
           e la mette in DONE

         */

        // chiamo il service per inserire in coda la pizza
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }



}
