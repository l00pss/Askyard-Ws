package az.askyard.askyardws.controller.api;

import az.askyard.askyardws.business.abstracts.UserService;
import az.askyard.askyardws.core.concretes.utilities.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/1.0/user/account",produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController<T> {
    private UserService userService;

    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }


    @DeleteMapping("/delete")
    public ResponseEntity<Result> deleteAccount(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> updateAccount(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
