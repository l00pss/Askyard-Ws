package az.askyard.askyardws.entities.concretes.user;


import az.askyard.askyardws.core.annotations.Unique;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User implements UserDetails {
    @SequenceGenerator(name = "USER_GEN_SEQ",
            sequenceName = "USER_SEQ",
            allocationSize = 100,
            initialValue = 10
    )

    @Id
    @GeneratedValue(generator = "USER_GEN_SEQ")
    private long userId;

    @Column(name = "NAME_OF_USER")
    @Size(min = 2,max = 30) @NotNull(message = "{askyard.validation.az.NotNull.message}")
    private String firstName;

    @Column(name = "LASTNAME_OF_USER")
    @Size(min = 2,max = 30) @NotNull
    private String lastName;

    @Column(name = "NICKNAME_OF_USER",unique = true,updatable = false)
    @Size(min = 4,max = 30) @NotNull
    @Unique
    private String userName;

    @Column(name = "PASSWORD_OF_USER") @NotNull
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    private String password;

    @Column(name = "EMAIL_OF_USER",unique = true)
    @Size(min = 8,max = 35)
    @Email @NotNull
    private String email;

    @OneToOne(mappedBy = "ownerProfile",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private Profile profileOfUser;





    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
