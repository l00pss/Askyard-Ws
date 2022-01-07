package az.askyard.askyardws.dto;

import az.askyard.askyardws.entities.concretes.factory.AbstractUserEntityFactory;
import az.askyard.askyardws.entities.concretes.factory.FactoryUserEntity;
import az.askyard.askyardws.entities.concretes.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@Getter
public class UserRegisterDTO {
    @JsonIgnore
    private final transient AbstractUserEntityFactory userEntityFactory = new FactoryUserEntity();

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User cloneToEntity(){
        User user = userEntityFactory.factory();
        user.setUserName(this.userName);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setPassword(new BCryptPasswordEncoder().encode(this.password));
        user.setEmail(this.email);
        user.setPosts(new ArrayList<>());
        return user;
    }

}
