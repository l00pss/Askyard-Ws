package az.askyard.askyardws.core.concretes.utilities.result.success;

import az.askyard.askyardws.core.concretes.utilities.result.Result;

/**
 * @author Vugar Mammadli
 */
public class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true,message);
    }
}
