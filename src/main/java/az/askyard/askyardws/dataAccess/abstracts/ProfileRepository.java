package az.askyard.askyardws.dataAccess.abstracts;

import az.askyard.askyardws.entities.concretes.user.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository  extends JpaRepository<Profile,Long> {
}
