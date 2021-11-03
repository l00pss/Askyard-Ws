package az.askyard.askyardws.core.concretes.utilities.exceptions;

/**
 * @author Vugar Mammadli
 */
public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
