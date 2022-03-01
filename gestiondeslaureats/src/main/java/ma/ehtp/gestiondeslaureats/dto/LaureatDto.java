package ma.ehtp.gestiondeslaureats.dto;


import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@NoArgsConstructor
public class LaureatDto {

    private long id;

    private String adresse;

    private String secteur;

    private double latitude;

    private double longitude;

    /*@JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private Point geometry;
*/
    private String description;

    private String entreprise_actuelle;

    private String motif_de_rejet;

    private int promotion;

    private String statut;

    private String filiere;

    private String nom;

    private String Email;

    private String telephone;

    private String role;
}
