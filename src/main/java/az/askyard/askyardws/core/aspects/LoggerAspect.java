package az.askyard.askyardws.core.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Vugar Mammadli
 */

@Aspect
@Component
public class LoggerAspect {
    //private static final Logger LOGGER  = Logger.getLogger(UserManager.class.getName());

    @Around("@annotation(az.askyard.askyardws.core.annotations.Logger)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        Object proceed = joinPoint.proceed();
        Instant stop = Instant.now();
        System.out.println(joinPoint.getSignature() + " executed in " + Duration.between(start,stop).toNanos() + "ms");
        return proceed;
    }
}
