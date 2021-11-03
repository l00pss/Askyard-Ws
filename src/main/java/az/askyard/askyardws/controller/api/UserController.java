package az.askyard.askyardws.controller.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0/user")
public class UserController {


    @GetMapping("/findAll")
    public ResponseEntity findAllUsers(){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(){
        return new ResponseEntity(HttpStatus.CREATED);
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
