package az.askyard.askyardws.dto;

import az.askyard.askyardws.entities.concretes.user.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@Data
public class UserRegisterDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User factory(){
        User user = new User();
        user.setUserName(this.userName);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setPassword(new BCryptPasswordEncoder().encode(this.password));
        user.setEmail(this.email);
        user.setPosts(new ArrayList<>());
        return user;
    }
}
