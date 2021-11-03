package az.askyard.askyardws.controller.advices;

import az.askyard.askyardws.core.concretes.utilities.exceptions.NullValueException;
import az.askyard.askyardws.core.concretes.utilities.exceptions.InvalidCharacterException;
import az.askyard.askyardws.core.concretes.utilities.exceptions.UnauthorizationException;
import az.askyard.askyardws.core.concretes.utilities.exceptions.UserNotFoundException;
import az.askyard.askyardws.core.concretes.utilities.messages.error.UserErrorMessages;
import az.askyard.askyardws.core.concretes.utilities.result.error.ErrorDataResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NullValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handlerNullValueException(NullValueException exception){
        return new ErrorDataResult<>(UserErrorMessages.NULL_VALUE.getValue());
    }

    @ExceptionHandler(InvalidCharacterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handlerInvalidCharacterException(InvalidCharacterException invalidCharacterException){
        return new ErrorDataResult<Object>(UserErrorMessages.INVALID_CHARACTER.getValue());
    }

    @ExceptionHandler(UnauthorizationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorDataResult<Object> handlerUnauthorizationException(UnauthorizationException invalidCharacterException){
        return new ErrorDataResult<Object>(UserErrorMessages.UNAUTH.getValue());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handlerUnknowException(MethodArgumentNotValidException methodArgumentNotValidException){
        return new ErrorDataResult<Object>(UserErrorMessages.ERROR.getValue());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDataResult<Object> handlerUnknowException(UserNotFoundException userNotFoundException){
        return new ErrorDataResult<Object>(UserErrorMessages.USER_NOT_FOUND.getValue());
    }


}
