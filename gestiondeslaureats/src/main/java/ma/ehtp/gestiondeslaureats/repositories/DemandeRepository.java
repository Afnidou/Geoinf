package ma.ehtp.gestiondeslaureats.repositories;

import ma.ehtp.gestiondeslaureats.domain.Demande;
import ma.ehtp.gestiondeslaureats.users.Laureat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {


}
