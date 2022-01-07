package az.askyard.askyardws.core.constraints;

import az.askyard.askyardws.core.annotations.Unique;
import az.askyard.askyardws.core.concretes.utilities.exceptions.SameUsernameException;
import az.askyard.askyardws.core.concretes.utilities.messages.error.UserRegisterErrors;
import az.askyard.askyardws.dataAccess.abstracts.UserRepository;
import az.askyard.askyardws.entities.concretes.user.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Vugar Mammadli
 */

@Component
public class UniqueValidation implements ConstraintValidator<Unique,String> {

    @Autowired
    UserRepository userRepository;

    @SneakyThrows(SameUsernameException.class)
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User user = userRepository.findByUserName(value);
        if(user!=null){
            throw new SameUsernameException(UserRegisterErrors.USERNAME_EXIST.getValue());
        }
        return true;
    }
}
