package ma.ehtp.gestiondeslaureats.repositories;

import ma.ehtp.gestiondeslaureats.filieres.Filiere;
import ma.ehtp.gestiondeslaureats.users.Laureat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiliereRepository extends JpaRepository<Filiere, Long> {
}
