package za.co.fnb.coindispenser.controller.rest.exception;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String errorMessage){
        super(errorMessage);
    }
}
