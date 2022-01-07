package az.askyard.askyardws.entities.concretes.factory;

import az.askyard.askyardws.entities.concretes.user.User;

public class FactoryUserEntity implements AbstractUserEntityFactory {
    private static volatile User user = null;

    @Override
    public User factory() {
        if (user==null){
            synchronized (FactoryUserEntity.class){
                if (user==null){
                    user = new User();
                }
            }
        }
        return user;
    }
}
