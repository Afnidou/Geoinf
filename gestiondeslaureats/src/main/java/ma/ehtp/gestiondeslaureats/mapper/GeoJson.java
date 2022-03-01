package ma.ehtp.gestiondeslaureats.mapper;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor
public class GeoJson {
    private String type ="FeatureCollection";
    private List<Feature> features;
}
