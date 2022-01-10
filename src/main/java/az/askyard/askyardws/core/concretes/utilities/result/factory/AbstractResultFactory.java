package az.askyard.askyardws.core.concretes.utilities.result.factory;

import az.askyard.askyardws.core.concretes.utilities.result.error.ErrorDataResult;
import az.askyard.askyardws.core.concretes.utilities.result.error.ErrorResult;
import az.askyard.askyardws.core.concretes.utilities.result.success.SuccessDataResult;
import az.askyard.askyardws.core.concretes.utilities.result.success.SuccessResult;


public abstract class AbstractResultFactory<T> {

    public abstract SuccessResult factorySuccessResult(String message);

    public abstract ErrorResult factoryErrorResult(String message);

    public abstract SuccessDataResult<T> factorySuccessDataResult(T data,String message);

    public abstract ErrorDataResult<T> factoryErrorDataResult(T data, String message);
}
