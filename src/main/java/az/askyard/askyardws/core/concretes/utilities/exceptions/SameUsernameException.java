package az.askyard.askyardws.core.concretes.utilities.exceptions;

public class SameUsernameException  extends SameValueFieldException{
    public SameUsernameException() {
    }

    public SameUsernameException(String message) {
        super(message);
    }
}
