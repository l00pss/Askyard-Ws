package az.askyard.askyardws.core.constraints;

import az.askyard.askyardws.core.annotations.Unique;
import az.askyard.askyardws.dataAccess.abstracts.UserRepository;
import az.askyard.askyardws.entities.concretes.user.User;
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


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User user = userRepository.findByUserName(value);
        if(user!=null){
            return false;
        }
        return true;
    }
}
