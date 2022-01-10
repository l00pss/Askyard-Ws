package az.askyard.askyardws.entities.concretes.dto;

import az.askyard.askyardws.entities.concretes.factory.AbstractUserFactory;
import az.askyard.askyardws.entities.concretes.factory.FactoryUser;
import az.askyard.askyardws.entities.concretes.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@Getter
public class UserRegisterDTO {
    @JsonIgnore
    private final transient AbstractUserFactory userEntityFactory = new FactoryUser();

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User cloneToEntity(){
        User user = userEntityFactory.factoryUser();
        user.setUserName(this.userName);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setPassword(new BCryptPasswordEncoder().encode(this.password));
        user.setEmail(this.email);
        user.setPosts(new ArrayList<>());
        return user;
    }

}
