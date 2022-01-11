package az.askyard.askyardws.entities.concretes;

import az.askyard.askyardws.entities.concretes.post.Post;
import az.askyard.askyardws.entities.concretes.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REPORTS")
public class Report {
    @SequenceGenerator(name = "REPORT_GEN_SEQ",
            sequenceName = "REPORT_SEQ",
            allocationSize = 100,
            initialValue = 10
    )

    @Id @JsonIgnore
    @GeneratedValue(generator = "REPORT_GEN_SEQ")
    private long reportId;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private Post post;


    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private User reporter;


    @Column(name = "MESSAGE")
    @Size(min = 5,max = 300)
    private String message;

    @Column(name = "SCREENSHOOT")
    private String screenShoot;
}
