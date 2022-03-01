package ma.ehtp.gestiondeslaureats.users;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehtp.gestiondeslaureats.domain.Demande;
import ma.ehtp.gestiondeslaureats.secteurs.Secteur;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "laureats")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Laureat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @OneToOne(cascade = {CascadeType.ALL})
    private Demande demande;

    @OneToOne(cascade = {CascadeType.ALL})
    private User user;

}

/*
*
*  @NotBlank
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
    *
    * @OneToOne(cascade = {CascadeType.ALL})
    private Demande demande;
    * */