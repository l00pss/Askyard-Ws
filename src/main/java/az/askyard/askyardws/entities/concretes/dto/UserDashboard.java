package az.askyard.askyardws.entities.concretes.dto;

import az.askyard.askyardws.entities.concretes.post.Post;
import az.askyard.askyardws.entities.concretes.user.User;
import lombok.Getter;

import java.util.List;

@Getter
public class UserDashboard {
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String currentProfileImage;
    private final List<Post> posts;


    public UserDashboard(User user){
        this.userName = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.currentProfileImage = user.getCurrentProfileImage();
        this.posts=user.getPosts();
    }
}
