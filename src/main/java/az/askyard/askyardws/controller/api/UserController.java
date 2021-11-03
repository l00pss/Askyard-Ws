package az.askyard.askyardws.controller.api;


import az.askyard.askyardws.business.abstracts.UserService;
import az.askyard.askyardws.dto.UserRegisterDTO;
import az.askyard.askyardws.entities.concretes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/1.0/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/findAll")
    public ResponseEntity findAllUsers(){
        return new ResponseEntity(this.userService.findAll(),HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody UserRegisterDTO user){
        return new ResponseEntity(userService.registerUser(user),HttpStatus.CREATED);
    }

    @DeleteMapping("/account/delete")
    public ResponseEntity deleteAccount(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateAccount(){
        return new ResponseEntity(HttpStatus.OK);
    }



}
