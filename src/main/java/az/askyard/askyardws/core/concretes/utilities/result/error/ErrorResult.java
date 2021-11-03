package az.askyard.askyardws.core.concretes.utilities.result.error;

import az.askyard.askyardws.core.concretes.utilities.result.Result;

public class ErrorResult extends Result {
    public ErrorResult(){
        super(false);
    }
    public ErrorResult(String message){
        super(false,message);
    }
}
