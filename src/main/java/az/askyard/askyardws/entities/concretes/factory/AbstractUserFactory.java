package az.askyard.askyardws.entities.concretes.factory;

import az.askyard.askyardws.entities.concretes.dto.UserAccount;
import az.askyard.askyardws.entities.concretes.dto.UserDTO;
import az.askyard.askyardws.entities.concretes.user.User;

public interface AbstractUserFactory {
    User factoryUser();
    User factoryUser(UserAccount account);
    UserDTO factoryUserDTO(User user);
}
