package az.askyard.askyardws.controller.handler;

import az.askyard.askyardws.core.concretes.utilities.messages.error.UserErrorMessages;
import az.askyard.askyardws.core.concretes.utilities.result.error.ErrorDataResult;
import az.askyard.askyardws.core.concretes.utilities.result.factory.AbstractResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class AuthErrorHandler implements ErrorController {


    private ErrorAttributes errorAttributes;
    private AbstractResultFactory<LocalDateTime> abstractResultFactory;

    @Autowired
    public AuthErrorHandler(ErrorAttributes errorAttributes,AbstractResultFactory<LocalDateTime> abstractResultFactory) {
        this.errorAttributes = errorAttributes;
        this.abstractResultFactory=abstractResultFactory;
    }


    @RequestMapping("/error")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<LocalDateTime> handlerUserNotFoundException(WebRequest request){
        iterateErrors(request);
        return abstractResultFactory.factoryErrorDataResult(UserErrorMessages.USER_NOT_FOUND.getValue());
    }

    @SuppressWarnings("unchecked")
    private void iterateErrors(WebRequest request){
        Map<String, Object> attributes = this.errorAttributes.getErrorAttributes(request, ErrorAttributeOptions.of());
        List<FieldError> fieldErrorList = (List<FieldError>) attributes.get("errors");
    }
}
