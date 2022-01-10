package az.askyard.askyardws.core.concretes.utilities.result.error;

import az.askyard.askyardws.core.concretes.utilities.result.Result;
import org.springframework.boot.web.servlet.error.ErrorController;

public class ErrorResult extends Result implements ErrorController {
    public ErrorResult(){
        super(false);
    }
    public ErrorResult(String message){
        super(false,message);
    }

}
