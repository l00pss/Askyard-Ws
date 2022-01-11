package az.askyard.askyardws.controller.auth;

import az.askyard.askyardws.core.annotations.CurrentUser;
import az.askyard.askyardws.core.concretes.utilities.messages.success.UserSuccessMessages;
import az.askyard.askyardws.core.concretes.utilities.result.factory.AbstractResultFactory;
import az.askyard.askyardws.core.concretes.utilities.result.success.SuccessDataResult;
import az.askyard.askyardws.entities.concretes.dto.UserDTO;
import az.askyard.askyardws.entities.concretes.factory.AbstractUserFactory;
import az.askyard.askyardws.entities.concretes.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final AbstractResultFactory<UserDTO> resultFactory;
    private final AbstractUserFactory factory;

    @Autowired
    public AuthController(AbstractResultFactory<UserDTO> resultFactory, AbstractUserFactory userFactory) {
        this.resultFactory=resultFactory;
        this.factory = userFactory;
    }

    @PostMapping(value = "/api/1.0/auth" ,produces  = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<SuccessDataResult<UserDTO>> handlerAuth(@CurrentUser User user){
        SuccessDataResult<UserDTO> dataResult = null;
        if(!user.isFrozen()){
            dataResult = resultFactory.factorySuccessDataResult(factory.factoryUserDTO(user), UserSuccessMessages.AUTH.getValue());
        }else {
            user.setFrozen(true);
            dataResult = resultFactory.factorySuccessDataResult(factory.factoryUserDTO(user), UserSuccessMessages.UNFROZEN.getValue());
        }
        return new ResponseEntity<>(dataResult, HttpStatus.ACCEPTED);
    }

}