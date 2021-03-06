package az.askyard.askyardws.core.concretes.utilities.result.success;

import az.askyard.askyardws.core.concretes.utilities.result.DataResult;

/**
 * @author Vugar Mammadli
 */
public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data,String message) {
        super(data, true, message);
    }

    public SuccessDataResult(T data){
        super(true,data);
    }

    public SuccessDataResult(String message){
        super(null,true,message);
    }

    public SuccessDataResult(){
        super(true,null);
    }


}
