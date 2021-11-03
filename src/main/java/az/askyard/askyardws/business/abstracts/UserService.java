package az.askyard.askyardws.business.abstracts;

import az.askyard.askyardws.core.concretes.utilities.result.DataResult;
import az.askyard.askyardws.dto.UserDTO;
import az.askyard.askyardws.dto.UserRegisterDTO;
import az.askyard.askyardws.entities.concretes.user.User;

import java.util.List;

public interface UserService {

    DataResult<User> registerUser(UserRegisterDTO user);
    DataResult<List<UserDTO>> findAll();
    DataResult<List<UserDTO>> findAllFriends(User user);
}
