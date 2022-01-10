package az.askyard.askyardws.core.concretes.utilities.result.factory;

import az.askyard.askyardws.core.concretes.utilities.result.error.ErrorDataResult;
import az.askyard.askyardws.core.concretes.utilities.result.error.ErrorResult;
import az.askyard.askyardws.core.concretes.utilities.result.success.SuccessDataResult;
import az.askyard.askyardws.core.concretes.utilities.result.success.SuccessResult;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ResultFactory<T> extends AbstractResultFactory<T>{

    @Override
    public SuccessResult factorySuccessResult(String message) {
        return new SuccessResult(message);
    }

    @Override
    public ErrorResult factoryErrorResult(String message) {
        return new ErrorResult(message);
    }

    @Override
    public SuccessDataResult<T> factorySuccessDataResult(T data,String message) {
        return new SuccessDataResult<T>(data,message);
    }

    @Override
    public ErrorDataResult<T> factoryErrorDataResult(String message) {
        return new ErrorDataResult<T>(message);
    }

    @Override
    public ErrorDataResult<T> factoryErrorDataResult(T data, String message) {
        return new ErrorDataResult<T>(data,message);
    }


}
