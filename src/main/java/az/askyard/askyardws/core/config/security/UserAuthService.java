package az.askyard.askyardws.core.config.security;

import az.askyard.askyardws.core.concretes.utilities.messages.error.UserErrorMessages;
import az.askyard.askyardws.dataAccess.abstracts.UserRepository;
import az.askyard.askyardws.entities.concretes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author Vugar Mammadli
 */
@Service
public class UserAuthService implements UserDetailsService {


    private UserRepository userRepository;

    @Autowired
    UserAuthService( UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(nickname);
        if(user==null)
            throw new UsernameNotFoundException(UserErrorMessages.USER_NOT_FOUND.getValue());
        return user;
    }
}
