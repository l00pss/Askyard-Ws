package az.askyard.askyardws.dataAccess.abstracts;

import az.askyard.askyardws.entities.concretes.user.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalitazionRepository extends JpaRepository<Localization,Long> {
}
