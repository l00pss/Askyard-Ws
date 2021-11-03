package az.askyard.askyardws.dto;

import az.askyard.askyardws.entities.concretes.post.Post;
import az.askyard.askyardws.entities.concretes.user.User;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String currentProfileImage;
    private String currentCoverImage;
    private String aboutOwner;
    private List<Post> postList;

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
