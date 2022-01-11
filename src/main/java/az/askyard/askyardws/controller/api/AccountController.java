package az.askyard.askyardws.controller.api;

import az.askyard.askyardws.business.abstracts.AccountService;
import az.askyard.askyardws.business.abstracts.UserService;
import az.askyard.askyardws.core.annotations.CurrentUser;
import az.askyard.askyardws.core.concretes.utilities.result.Result;
import az.askyard.askyardws.entities.concretes.dto.UserAccount;
import az.askyard.askyardws.entities.concretes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/1.0/user/account",produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController<T> {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @DeleteMapping("/delete")
    public ResponseEntity<Result> deleteAccount(@CurrentUser User user){
        return new ResponseEntity<>(this.accountService.deleteAccount(user),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> updateAccount(@CurrentUser User currentUser, UserAccount account){
        return new ResponseEntity<>(this.accountService.updateAccount(currentUser, account),HttpStatus.OK);
    }

    @PutMapping("/frozen")
    public ResponseEntity<Result> frozenAccount(@CurrentUser User currentUser){
        return new ResponseEntity<>(this.accountService.frozenAccount(currentUser),HttpStatus.OK);
    }

    @PutMapping("/unfrozen")
    public ResponseEntity<Result> unfrozenAccount(@CurrentUser User currentUser){
        return new ResponseEntity<>(this.accountService.unFrozenAccount(currentUser),HttpStatus.OK);
    }
}
