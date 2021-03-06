package az.askyard.askyardws.entities.concretes.post;


import az.askyard.askyardws.entities.concretes.Report;
import az.askyard.askyardws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;


/**
 * @author Vugar Mammadli
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "POSTS")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOfPost;

    @ManyToOne(
            targetEntity = User.class
    )
    @JoinColumn(name = "userProfileId" ,nullable = false)
    private User authorOfPost;

    @Column(name = "CONTEXT")
    private String contextOfPost;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateOfPost = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateOfPost;

    @Column(name = "REPORT")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Report> report;

    @ElementCollection
    @CollectionTable(name = "LIKED_LIST_OF_POST",joinColumns = @JoinColumn(name = "ID_OF_POST"))
    private Set<Long> likedUserList = new TreeSet<>();


    //private List<String> photosOfPost = new ArrayList<>();


}

