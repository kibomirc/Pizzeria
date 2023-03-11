package pizzeria.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import pizzeria.model.Pizza;

import java.awt.*;

@RestController
public class ControllerCliente {

    // Service Pizzeria


    @PostMapping(path= "/cliente/ordinaPizza",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity ordinaPizza(@RequestBody Pizza pizza) {
        //ObjectMapper objectMapper = new ObjectMapper();
        //Pizza pizzaObj = objectMapper.convertValue(pizza,Pizza.class);

        /*
            Il service si occupera di generare un ticket e lo ritorniamo nella risposta

         */

        // chiamo il service per inserire in coda la pizza
        return ResponseEntity.status(HttpStatus.CREATED).body("0000"); // default ticket

    }

    @GetMapping("/cliente/getPizza")
    public ResponseEntity getPizza(@RequestParam String ticket) {

        // chiamo service vedere lo status della pizza passandogli il ticket
        return ResponseEntity.status(HttpStatus.OK).body("DONE");

    }


}
