package pizzeria.excepiton;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    public RestResponseEntityExceptionHandler() {
        super();
    }

    // Errore customizzato per la pizza che è già in preparazione
    @ExceptionHandler(PizzaIsBeingPreparing.class)
    public ResponseEntity<Object> pizzaIsBeingPreparing(final PizzaIsBeingPreparing ex, final WebRequest request) {
        logger.error("There is another pizza in preparing", ex);
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), String.valueOf(ex.getStackTrace()));
        ObjectMapper obj = new ObjectMapper();
        String jsonError = null;
        try {
            jsonError = obj.writeValueAsString(errorResponse);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return handleExceptionInternal(ex, jsonError, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    // Eccezioni customizzate
    @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
        logger.error("500 Status Code", ex);
        final String bodyOfResponse = "Error";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
