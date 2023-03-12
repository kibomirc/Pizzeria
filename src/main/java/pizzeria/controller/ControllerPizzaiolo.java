package pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pizzeria.service.PizzeriaService;

@RestController
public class ControllerPizzaiolo {

    @Autowired
    PizzeriaService pizzeriaService;


    // prende la prima pizza dal database con status TODO e la lavora
    @GetMapping("/pizzaiolo/makePizza")
    public ResponseEntity getPizza() {

        /*
           Chiamo service vedere lo status delle pizza
           se non c'è una pizza in lavorazione ("PREPARING")
           prendi la priam che ha lo status ("TO DO")


         */

        pizzeriaService.getPizza();

        return ResponseEntity.status(HttpStatus.OK).build();

    }



    @GetMapping("/pizzaiolo/donePizza")
    public ResponseEntity donePizza() {

        /*
           Prende lo status della pizza che sta in "PREPARING" ( ce ne sarà solo una )
           e la mette in DONE

         */

        pizzeriaService.donePizza();
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }



}
