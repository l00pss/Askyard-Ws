package az.askyard.askyardws.dataAccess.abstracts;

import az.askyard.askyardws.entities.concretes.user.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(long userId);

    @SuppressWarnings("unchecked")
    @NotNull
    User save(@NotNull User user);

    User findByUserName(String username);

    Page<User> findByUserNameNot(String username, Pageable pageable);

}
