package za.co.fnb.coindispenser.controller.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class controllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<DispenserErrorResponse> handleValidationExceptions(InvalidInputException ex){
        String errorMessage = "Input parameter(s) failed validation. :" + ex.getMessage();
        DispenserErrorResponse errorResponse = new DispenserErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setError(errorMessage);
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
