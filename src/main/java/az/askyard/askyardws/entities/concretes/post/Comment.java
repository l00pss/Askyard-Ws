package az.askyard.askyardws.entities.concretes.post;


import az.askyard.askyardws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOfComment;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private User writer;

    @Column(name = "CONTEXT")
    @Size(min = 1,max = 300)
    private String context;

    @OneToMany(
            fetch = FetchType.LAZY
    )
    private Set<User> likedUsers;
}
