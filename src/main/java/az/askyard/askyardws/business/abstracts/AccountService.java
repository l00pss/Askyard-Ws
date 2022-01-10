package az.askyard.askyardws.business.abstracts;

import az.askyard.askyardws.core.concretes.utilities.result.Result;
import az.askyard.askyardws.entities.concretes.dto.UserAccount;
import az.askyard.askyardws.entities.concretes.user.User;

public interface AccountService {

    Result deleteAccount(User currentUser);

    Result updateAccount(User currentUser, UserAccount account);

    Result frozenAccount(User currentUser);

    Result unFrozenAccount(User currentUser);


}
