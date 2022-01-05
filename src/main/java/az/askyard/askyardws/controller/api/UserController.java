package az.askyard.askyardws.controller.api;


import az.askyard.askyardws.business.abstracts.UserService;
import az.askyard.askyardws.core.annotations.CurrentUser;
import az.askyard.askyardws.core.concretes.utilities.result.DataResult;
import az.askyard.askyardws.core.concretes.utilities.result.Result;
import az.askyard.askyardws.dto.UserDTO;
import az.askyard.askyardws.dto.UserRegisterDTO;
import az.askyard.askyardws.entities.concretes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/user",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController<T> {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/findAll")
    public ResponseEntity<DataResult<List<UserDTO>>> findAllUsers(){
        return new ResponseEntity<>(this.userService.findAll(),HttpStatus.CREATED);
    }


    @GetMapping("/follow/{id}")
    public ResponseEntity<Result> follow(@CurrentUser User user, @PathVariable Long id){
        return new ResponseEntity<>(this.userService.follow(user,id),HttpStatus.OK);
    }

    @GetMapping("/unfollow/{id}")
    public ResponseEntity<Result> unfollow(@CurrentUser User user,@PathVariable Long id){
        return new ResponseEntity<>(this.userService.unfollow(user,id),HttpStatus.OK);
    }

    @GetMapping("/findAllFollow")
    public ResponseEntity<DataResult<List<UserDTO>>> findAllFriends(@CurrentUser User user){
        return new ResponseEntity<>(this.userService.findAllFollows(user),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<DataResult<User>> registerUser(@Valid @RequestBody UserRegisterDTO user){
        return new ResponseEntity<>(userService.registerUser(user),HttpStatus.CREATED);
    }

    @DeleteMapping("/account/delete")
    public ResponseEntity<Result> deleteAccount(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> updateAccount(){
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
