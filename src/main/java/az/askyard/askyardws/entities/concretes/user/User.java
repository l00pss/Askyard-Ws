package az.askyard.askyardws.entities.concretes.user;


import az.askyard.askyardws.core.annotations.Unique;
import az.askyard.askyardws.entities.concretes.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findSpecial",query = "select u from User u")
})
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

    @Id @JsonIgnore
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


    private String currentProfileImage;

    private String currentCoverImage;

    private String aboutOwner;

    @OneToMany(mappedBy = "authorOfPost",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Post> posts;

    @ElementCollection
    @CollectionTable(name="FollowsList",
            joinColumns = @JoinColumn(name="userId"))
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="followId",nullable = false)
    List<Long> followsList  = new ArrayList<>();

    @Override @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("Role_user");
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
