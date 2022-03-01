package ma.ehtp.gestiondeslaureats.repositories;

import ma.ehtp.gestiondeslaureats.users.Laureat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaureatRepository extends JpaRepository<Laureat, Long> {
}
