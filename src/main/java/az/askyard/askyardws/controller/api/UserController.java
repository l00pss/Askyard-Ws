package az.askyard.askyardws.controller.api;


import az.askyard.askyardws.business.abstracts.UserService;
import az.askyard.askyardws.core.annotations.CurrentUser;
import az.askyard.askyardws.dto.UserRegisterDTO;
import az.askyard.askyardws.entities.concretes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/1.0/user",produces = MediaType.APPLICATION_JSON_VALUE)
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


    @GetMapping("/findAllFirends")
    public ResponseEntity findAllFriends(@CurrentUser User user){
        return new ResponseEntity(this.userService.findAllFriends(user),HttpStatus.OK);
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
