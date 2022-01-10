package az.askyard.askyardws.entities.concretes.factory;

import az.askyard.askyardws.entities.concretes.dto.UserAccount;
import az.askyard.askyardws.entities.concretes.dto.UserDTO;
import az.askyard.askyardws.entities.concretes.user.User;
import org.springframework.stereotype.Component;

@Component
public class FactoryUser implements AbstractUserFactory {
    private static volatile User user = null;
    private static volatile UserDTO userDTO = null;
    private static volatile UserAccount account = null;

    @Override
    public User factoryUser() {
        if (user==null){
            synchronized (FactoryUser.class){
                if (user==null){
                    user = new User();
                }
            }
        }
        return user;
    }

    @Override
    public User factoryUser(UserAccount account) {
        if (account==null){
            synchronized (FactoryUser.class){
                if (account==null){
                    user = new User();
                }
            }
        }
        return user;
    }

    @Override
    public UserDTO factoryUserDTO(User user) {
        if (userDTO==null){
            synchronized (FactoryUser.class){
                if (userDTO==null){
                    userDTO = new UserDTO(user);
                }
            }
        }
        return userDTO;
    }


}
