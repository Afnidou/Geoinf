package ma.ehtp.gestiondeslaureats.service;


import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import ma.ehtp.gestiondeslaureats.dto.LaureatDto;
import ma.ehtp.gestiondeslaureats.mapper.Feature;
import ma.ehtp.gestiondeslaureats.mapper.GeoJson;
import ma.ehtp.gestiondeslaureats.mapper.LaureatDtoMapper;
import ma.ehtp.gestiondeslaureats.repositories.LaureatRepository;
import ma.ehtp.gestiondeslaureats.users.Laureat;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service @Data @AllArgsConstructor
public class LaureatService {

    private LaureatRepository laureatRepository;

    private LaureatDtoMapper laureatDtoMapper;

    public Laureat ajouter_laureat(@Valid Laureat laureat){
        locate_laureat(laureat);
        return laureatRepository.save(laureat);
    }

    public Feature ajouter_laureat_feature(@Valid Laureat laureat, Feature feature){
        ajouter_laureat(laureat);
        feature.setProperties(laureatDtoMapper.map(laureat));
        feature.setGeometry(laureat.getGeomtry());
        return feature;
    }

    public Point locate_laureat(Laureat laureat){
        Point localisation = new GeometryFactory().createPoint(
                new Coordinate(laureat.getLatitude(), laureat.getLongitude()));
        laureat.setGeomtry(localisation);
        return localisation;
    }

    public Point locate_laureat_dto(LaureatDto laureatDto){
        Point localisation = new GeometryFactory().createPoint(
                new Coordinate(laureatDto.getLatitude(), laureatDto.getLongitude()));
        return localisation;
    }

    public List get_all(){
       return laureatRepository.findAll();
    }

    public List<Feature> laureats_dto_to_features(List<LaureatDto> list_laureats_dto){
        List<Feature> list_features = list_laureats_dto.stream()
                .map(laureatDto -> new Feature(laureatDto,locate_laureat_dto(laureatDto)))
                .collect(Collectors.toList());
        return list_features;
    }

    public GeoJson get_all_geoJson(GeoJson geoJson){
        geoJson.setFeatures(laureats_dto_to_features(laureatDtoMapper.mapList(get_all())));
        return geoJson;
    }

}
