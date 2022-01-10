package az.askyard.askyardws.core.concretes.utilities.exceptions;

import az.askyard.askyardws.core.concretes.utilities.messages.error.UserErrorMessages;
import org.springframework.security.authentication.BadCredentialsException;

/**
 * @author Vugar Mammadli
 */
public class UserNotFoundException extends BadCredentialsException {
    public UserNotFoundException() {
        super(UserErrorMessages.USER_NOT_FOUND.getValue());
    }

}
