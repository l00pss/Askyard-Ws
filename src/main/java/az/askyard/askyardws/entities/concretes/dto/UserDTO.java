package az.askyard.askyardws.entities.concretes.dto;

import az.askyard.askyardws.entities.concretes.post.Post;
import az.askyard.askyardws.entities.concretes.user.User;
import lombok.Getter;

import java.util.List;

@Getter
public final class UserDTO {
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String currentProfileImage;
    private final String currentCoverImage;
    private final String aboutOwner;
    private final List<Post> postList;


    public UserDTO(User user){
        this.userName = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.currentCoverImage = user.getCurrentCoverImage();
        this.currentProfileImage = user.getCurrentProfileImage();
        this.aboutOwner = user.getAboutOwner();
        this.postList = user.getPosts();
    }

}
