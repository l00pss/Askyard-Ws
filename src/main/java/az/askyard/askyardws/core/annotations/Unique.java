package az.askyard.askyardws.core.annotations;

import az.askyard.askyardws.core.constraints.UniqueValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Vugar Mammadli
 */
@Documented
@Constraint(validatedBy = {UniqueValidation.class})
@Target(FIELD)
@Retention(RUNTIME)
public @interface Unique {

    String message() default "Nickname is alredy exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
