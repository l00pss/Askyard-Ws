package az.askyard.askyardws.core.aspects;

import az.askyard.askyardws.core.concretes.utilities.exceptions.NullValueException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class NotNullAspect {
    private static final Logger LOGGER  = Logger.getLogger(NotNullAspect.class.getName());

    @Before("@annotation(az.askyard.askyardws.core.annotations.NotNullCheck)")
    public void checkNullAdvice(JoinPoint joinPoint) throws Throwable {
        System.err.println("NULL ASPECT");
        String field = (String) joinPoint.getArgs()[0];
        if(field==null || field.equals("")) throw new NullValueException(new Throwable());
    }
}
