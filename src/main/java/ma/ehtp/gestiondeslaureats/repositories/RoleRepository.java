package ma.ehtp.gestiondeslaureats.repositories;

import ma.ehtp.gestiondeslaureats.roles.ERole;
import ma.ehtp.gestiondeslaureats.roles.Role;
import ma.ehtp.gestiondeslaureats.users.Laureat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
