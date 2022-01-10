package az.askyard.askyardws.core.concretes.utilities.result;

import az.askyard.askyardws.core.Views;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Vugar Mammadli
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class DataResult<T> extends Result{

    @JsonView(Views.Base.class)
    private T data;

    public DataResult(T data,boolean success, String message) {
        super(success, message);
        this.data=data;
    }

    public DataResult(boolean success, T data) {
        super(success);
        this.data = data;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
