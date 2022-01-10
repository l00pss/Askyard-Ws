package az.askyard.askyardws.entities.concretes.dto;


import az.askyard.askyardws.entities.concretes.factory.AbstractUserFactory;
import az.askyard.askyardws.entities.concretes.factory.FactoryUser;
import az.askyard.askyardws.entities.concretes.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

//for Update Account
public class UserAccount {
    @JsonIgnore
    private final transient AbstractUserFactory userEntityFactory = new FactoryUser();

    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String currentProfileImage;
    private final String currentCoverImage;
    private final String aboutOwner;


    public UserAccount(User user, String email){
        this.userName = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = email;
        this.currentCoverImage = user.getCurrentCoverImage();
        this.currentProfileImage = user.getCurrentProfileImage();
        this.aboutOwner = user.getAboutOwner();
    }

    public User cloneToEntity(User user){
        user.setUserName(this.userName);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setCurrentProfileImage(this.currentProfileImage);
        user.setCurrentCoverImage(this.currentCoverImage);
        user.setAboutOwner(this.aboutOwner);
        return user;
    }
}
