package az.askyard.askyardws.core.concretes.utilities.result;


import az.askyard.askyardws.core.Views;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import java.time.LocalDateTime;

/**
 * @author Vugar Mammadli
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    @JsonView(Views.Base.class)
    private boolean success;

    @JsonView(Views.Base.class)
    private String message;

    @JsonView(Views.Base.class)
    private LocalDateTime time;

    public Result(boolean success, String message) {
        this(success); // Bool Constractoru cagiri
        this.message = message;
        this.time = LocalDateTime.now();
    }

    public Result(boolean success) { //bool Constroctor
        this.success = success;
        this.time = LocalDateTime.now();
    }

    public boolean isSuccess(){
        return this.success;
    }

    public String getMessage(){
        return this.message;
    }
}
