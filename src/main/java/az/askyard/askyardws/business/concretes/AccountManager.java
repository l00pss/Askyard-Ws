package az.askyard.askyardws.business.concretes;

import az.askyard.askyardws.business.abstracts.AccountService;
import az.askyard.askyardws.core.concretes.utilities.messages.success.UserSuccessMessages;
import az.askyard.askyardws.core.concretes.utilities.result.Result;
import az.askyard.askyardws.core.concretes.utilities.result.factory.AbstractResultFactory;
import az.askyard.askyardws.dataAccess.abstracts.UserRepository;
import az.askyard.askyardws.entities.concretes.dto.UserAccount;
import az.askyard.askyardws.entities.concretes.factory.AbstractUserFactory;
import az.askyard.askyardws.entities.concretes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountManager implements AccountService {

    private UserRepository userRepository;
    private AbstractResultFactory<UserAccount> factory;
    private AbstractUserFactory userFactory;

    @Autowired
    public AccountManager(UserRepository userRepository, AbstractResultFactory<UserAccount> factory) {
        this.userRepository = userRepository;
        this.factory = factory;
    }

    @Override
    public Result deleteAccount(User currentUser) {
        userRepository.delete(currentUser);
        return factory.factorySuccessResult(UserSuccessMessages.DELETE.getValue());
    }

    @Override
    public Result updateAccount(User currentUser, UserAccount account) {
        User user = account.cloneToEntity(currentUser);
        this.userRepository.save(user);
        return factory.factorySuccessDataResult(account,UserSuccessMessages.UPDATE.getValue());
    }

    @Override
    public Result frozenAccount(User currentUser) {
        if(currentUser.isFrozen())
            currentUser.setFrozen(false);
        this.userRepository.save(currentUser);
        return factory.factorySuccessResult(UserSuccessMessages.FROZEN.getValue());
    }


    @Override
    public Result unFrozenAccount(User currentUser) {
        if(!currentUser.isFrozen())
            currentUser.setFrozen(true);
        this.userRepository.save(currentUser);
        return factory.factorySuccessResult(UserSuccessMessages.UNFROZEN.getValue());
    }

}
