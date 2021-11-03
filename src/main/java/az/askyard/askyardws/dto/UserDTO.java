package az.askyard.askyardws.dto;

import az.askyard.askyardws.entities.concretes.user.User;

import java.util.Date;

public class UserDTO {
    String userName;
    String firstName;
    String lastName;
    String email;

    public UserDTO(User user){
        this.userName = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }
}
