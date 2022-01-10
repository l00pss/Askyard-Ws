package az.askyard.askyardws.core.concretes.utilities.result.error;

import az.askyard.askyardws.core.concretes.utilities.result.DataResult;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;

public class ErrorDataResult<T> extends DataResult {
    public ErrorDataResult(T data,String message) {
        super(data, false, message);
    }

    public ErrorDataResult(T data,String message,Exception exception) {
        super(data, false, message);
    }
    public ErrorDataResult(T data){
        super(false,data);
    }

    public ErrorDataResult(String message){
        super(null,false,message);
    }

    public ErrorDataResult(){
        super(false,null);
    }
}
