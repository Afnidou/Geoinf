/*package ma.ehtp.gestiondeslaureats.domain;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.ehtp.gestiondeslaureats.filieres.Filiere;
import ma.ehtp.gestiondeslaureats.secteurs.Secteur;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "demandesInscr")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DemandeInscr {
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

    private Date dateDemande;

    private Date dateTraitement;

    @NotBlank
    private String adresse;

    @OneToOne(cascade = {CascadeType.ALL} ,fetch = FetchType.EAGER)
    private Secteur secteur;

    @NotBlank
    private double latitude;

    @NotBlank
    private double longitude;

    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private Point geomtry;

    @NotBlank
    @Column(length = 100)
    private String description;

    @NotBlank
    private String entreprise_actuelle;
}*/
