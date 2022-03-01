package ma.ehtp.gestiondeslaureats.RestControllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import ma.ehtp.gestiondeslaureats.mapper.Feature;
import ma.ehtp.gestiondeslaureats.mapper.GeoJson;
import ma.ehtp.gestiondeslaureats.service.LaureatService;
import ma.ehtp.gestiondeslaureats.users.Laureat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("*")
@RestController @Data @AllArgsConstructor
@RequestMapping("/api")
public class LaureatController {

    private LaureatService laureatService;

    @PostMapping("/laureats")
    @ResponseStatus(HttpStatus.CREATED)

    public Feature ajouter(@RequestBody @Valid Laureat laureat, Feature feature){
        return laureatService.ajouter_laureat_feature(laureat,feature);
    }

  // @CrossOrigin(origins = "http://localhost:9092")
    @GetMapping("/laureats")
    @ResponseBody
    public GeoJson get_all_laureats(GeoJson geoJson){
        return laureatService.get_all_geoJson(geoJson);
    }



}
