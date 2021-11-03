package az.askyard.askyardws.core.concretes.utilities.exceptions;

/**
 * @author Vugar Mammadli
 */
public class NullValueException extends Exception{
    public static String FIELD_NAME;
    public NullValueException(Throwable throwable) {
        super("Boş dəyər verilə bilməz");
        throwable.printStackTrace();
    }

    public NullValueException() {

    }
}
