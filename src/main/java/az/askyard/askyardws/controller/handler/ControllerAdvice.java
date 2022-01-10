package az.askyard.askyardws.controller.handler;

import az.askyard.askyardws.core.concretes.utilities.exceptions.*;
import az.askyard.askyardws.core.concretes.utilities.messages.error.UserErrorMessages;
import az.askyard.askyardws.core.concretes.utilities.result.error.ErrorDataResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    private final static Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);


    @ExceptionHandler(NullValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<String> handlerNullValueException(NullValueException exception){
        logger.error(exception.getMessage());
        return new ErrorDataResult<>(UserErrorMessages.NULL_VALUE.getValue());
    }

    @ExceptionHandler(InvalidCharacterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<String> handlerInvalidCharacterException(InvalidCharacterException invalidCharacterException){
        return new ErrorDataResult<>(UserErrorMessages.INVALID_CHARACTER.getValue());
    }

    @ExceptionHandler(UnauthorizationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorDataResult<String> handlerUnauthorizationException(UnauthorizationException invalidCharacterException){
        return new ErrorDataResult<>(UserErrorMessages.UNAUTH.getValue());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<String> handlerUnknowException(MethodArgumentNotValidException methodArgumentNotValidException){
        return new ErrorDataResult<>(UserErrorMessages.ERROR.getValue());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDataResult<String> handlerUnknownException(UserNotFoundException userNotFoundException){
        return new ErrorDataResult<>(UserErrorMessages.USER_NOT_FOUND.getValue());
    }



    @ExceptionHandler(SameUsernameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<String> handlerSameFieldException(SameUsernameException exception){
        return new ErrorDataResult<>(exception.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDataResult<String> handlerSameFieldException(UsernameNotFoundException exception){
        return new ErrorDataResult<>(exception.getMessage());
    }


    @ExceptionHandler(RequestRejectedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<String> handlerRequestRejectedException(RequestRejectedException exception){
        return new ErrorDataResult<>("Yanlis Istek Novu");
    }
}
