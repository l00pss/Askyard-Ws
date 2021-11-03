package az.askyard.askyardws.entities.concretes.user;


import az.askyard.askyardws.entities.concretes.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "PROFILE")
public class Profile {
    @SequenceGenerator(name = "USER_GEN_SEQ",
            sequenceName = "USER_SEQ",
            allocationSize = 100,
            initialValue = 10
    )

    @Id
    @GeneratedValue(generator = "USER_GEN_SEQ")
    private long profileId;

    @OneToOne
    @JoinColumn(name = "userId")
    private User ownerProfile;

    private String currentProfileImage;

    private String currentCoverImage;

    private String aboutOwner;


    @OneToMany(mappedBy = "authorOfPost",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Post> posts;


}
