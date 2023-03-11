package pizzeria.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import pizzeria.model.Pizza;
import pizzeria.service.PizzeriaService;

import java.awt.*;

@RestController
public class ControllerCliente {

    @Autowired
    PizzeriaService pizzeriaService;

    @PostMapping(path= "/cliente/ordinaPizza",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity ordinaPizza(@RequestBody Pizza pizza) {

        /*
            Il service si occupera di generare un ticket e lo ritorniamo nella risposta
         */

        // chiamo il service per inserire in coda la pizza
        String ticket = pizzeriaService.ordinaPizza(pizza);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket); // default ticket

    }

    @GetMapping("/cliente/getPizza")
    public ResponseEntity getPizza(@RequestParam String ticket) {

        // chiamo service vedere lo status della pizza passandogli il ticket
        String status = pizzeriaService.getPizza(ticket);
        return ResponseEntity.status(HttpStatus.OK).body(status);

    }


}
