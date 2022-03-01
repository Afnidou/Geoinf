package ma.ehtp.gestiondeslaureats.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.ehtp.gestiondeslaureats.filieres.Filiere;
import ma.ehtp.gestiondeslaureats.users.Laureat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "demandes")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = {CascadeType.ALL})
    private Filiere filiere;

    @NotBlank
    private String statut = "Non traité";

    private String motif_de_rejet;

    @NotBlank
    private int promotion;





}
