package ma.ehtp.gestiondeslaureats.mapper;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehtp.gestiondeslaureats.dto.LaureatDto;
@Data
@NoArgsConstructor
public class Feature {
    private String type = "Feature";
    private LaureatDto properties;
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private Point geometry;

    public Feature(LaureatDto properties, Point geometry) {
        this.properties = properties;
        this.geometry = geometry;
    }
}
