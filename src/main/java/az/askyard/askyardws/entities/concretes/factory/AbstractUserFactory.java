package az.askyard.askyardws.entities.concretes.factory;

import az.askyard.askyardws.entities.concretes.dto.UserDTO;
import az.askyard.askyardws.entities.concretes.user.User;

public interface AbstractUserFactory {
    User factoryUser();
    UserDTO factoryUserDTO(User user);
}
