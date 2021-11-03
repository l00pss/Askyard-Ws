package az.askyard.askyardws.controller.auth;

import az.askyard.askyardws.core.annotations.CurrentUser;
import az.askyard.askyardws.core.concretes.utilities.messages.success.UserSuccessMessages;
import az.askyard.askyardws.core.concretes.utilities.result.DataResult;
import az.askyard.askyardws.core.concretes.utilities.result.success.SuccessDataResult;
import az.askyard.askyardws.dataAccess.abstracts.UserRepository;
import az.askyard.askyardws.dto.UserDTO;
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

    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    UserRepository userService;

    @Autowired
    public AuthController(UserRepository userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/api/1.0/auth" ,produces  = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<DataResult> handlerAuth(@CurrentUser User user){
        SuccessDataResult<UserDTO> dataResult =  new SuccessDataResult<UserDTO>(new UserDTO(user), UserSuccessMessages.AUTH.getValue());
        return new ResponseEntity<>(dataResult, HttpStatus.ACCEPTED);
    }
}