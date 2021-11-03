package az.askyard.askyardws.dataAccess.abstracts;

import az.askyard.askyardws.entities.concretes.user.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository  extends JpaRepository<Profile,Long> {
}
