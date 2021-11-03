package az.askyard.askyardws.dataAccess.abstracts;

import az.askyard.askyardws.entities.concretes.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserid(long userId);
    User save(User user);

    User findByUserName(String username);

    Page<User> findByUserNameNot(String username, Pageable pageable);




}
