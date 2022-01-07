package az.askyard.askyardws.core.concretes.utilities.exceptions;

public class SameEmailException extends SameValueFieldException{
    public SameEmailException() {
    }

    public SameEmailException(String message) {
        super(message);
    }
}
