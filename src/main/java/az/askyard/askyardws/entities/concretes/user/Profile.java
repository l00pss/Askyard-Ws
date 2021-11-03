package az.askyard.askyardws.entities.concretes.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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


}
