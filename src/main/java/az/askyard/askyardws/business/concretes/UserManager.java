package az.askyard.askyardws.business.concretes;

import az.askyard.askyardws.business.abstracts.UserService;
import az.askyard.askyardws.core.concretes.utilities.messages.success.UserSuccessMessages;
import az.askyard.askyardws.core.concretes.utilities.result.DataResult;
import az.askyard.askyardws.core.concretes.utilities.result.Result;
import az.askyard.askyardws.core.concretes.utilities.result.success.SuccessDataResult;
import az.askyard.askyardws.core.concretes.utilities.result.success.SuccessResult;
import az.askyard.askyardws.dataAccess.abstracts.UserRepository;
import az.askyard.askyardws.dto.UserDTO;
import az.askyard.askyardws.dto.UserRegisterDTO;
import az.askyard.askyardws.entities.concretes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override @SuppressWarnings("unchecked")
    public DataResult<User> registerUser(UserRegisterDTO user) {
        return new SuccessDataResult<User>(this.userRepository.save(user.factory()), UserSuccessMessages.SAVE.getValue());
    }

    @Override @SuppressWarnings("unchecked")
    public DataResult<List<UserDTO>> findAll() {
        List<UserDTO> list = this.userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
        return new SuccessDataResult<List<UserDTO>>(list,UserSuccessMessages.FIND_ALL.getValue());
    }

    @Override @SuppressWarnings("unchecked")
    public DataResult<List<UserDTO>> findAllFollows(User user) {
        List<UserDTO> list = this.userRepository.findAllById(user.getFollowsList()).stream().map(UserDTO::new).collect(Collectors.toList());
        return new SuccessDataResult<List<UserDTO>>(list,UserSuccessMessages.FIND_BY_ID.getValue());
    }

    @Override
    public Result follow(User user,Long id) {
        if(!user.getFollowsList().contains(id)){
            user.getFollowsList().add(id);
            this.userRepository.save(user);
        }
        return new SuccessResult(UserSuccessMessages.FOLLOW.getValue());
    }

    @Override
    public Result unfollow(User user, Long id) {
        user.getFollowsList().remove(id);
        this.userRepository.save(user);
        return new SuccessResult(UserSuccessMessages.UNFOLLOW.getValue());
    }

    @Override
    public DataResult<List<UserDTO>> justTest() {

        return null;
    }
}
