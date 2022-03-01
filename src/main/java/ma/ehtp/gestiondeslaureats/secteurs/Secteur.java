package ma.ehtp.gestiondeslaureats.secteurs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehtp.gestiondeslaureats.roles.ERole;

import javax.persistence.*;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "secteurs")
public class Secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ESecteur name;
}
