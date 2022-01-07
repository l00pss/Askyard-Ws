package az.askyard.askyardws.core.aspects;

import az.askyard.askyardws.core.concretes.utilities.exceptions.InvalidCharacterException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class SymbolCheckAspect {
    private static final Logger LOGGER  = Logger.getLogger(SymbolCheckAspect.class.getName());

    private final Character[] CHARACTERS = {'@','!','_','%',',','.','?','>','<','$','#',' '};

    @Before("@annotation(az.askyard.askyardws.core.annotations.SymbolCheck)")
    public void checkSymbol(JoinPoint joinPoint) throws Throwable{
        System.out.println("Symbol Check ADVICE");
        String field = (String) joinPoint.getArgs()[0];
        for (int i = 0;i < CHARACTERS.length-1;i++)
            if(field.contains(CHARACTERS[i].toString())) throw new InvalidCharacterException();
    }
}
