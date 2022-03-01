package ma.ehtp.gestiondeslaureats.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehtp.gestiondeslaureats.dto.LaureatDto;
import ma.ehtp.gestiondeslaureats.users.Laureat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data @AllArgsConstructor
public class LaureatDtoMapper {
    // private LaureatDto laureatDto;
    public  LaureatDto map(Laureat laureat){
        LaureatDto laureatDto= new LaureatDto();
        laureatDto.setId(laureat.getId());
        laureatDto.setAdresse(laureat.getAdresse());
        laureatDto.setDescription(laureat.getDescription());
        laureatDto.setEntreprise_actuelle(laureat.getEntreprise_actuelle());
        laureatDto.setFiliere(laureat.getDemande().getFiliere().getName().toString());
        laureatDto.setLatitude(laureat.getLatitude());
        laureatDto.setLongitude(laureat.getLongitude());
       // laureatDto.setGeometry(laureat.getGeomtry());
        laureatDto.setMotif_de_rejet(laureat.getDemande().getMotif_de_rejet());
        laureatDto.setPromotion(laureat.getDemande().getPromotion());
        laureatDto.setStatut(laureat.getDemande().getStatut());
        laureatDto.setSecteur(laureat.getSecteur().getName().toString());
        laureatDto.setNom(laureat.getUser().getUsername());
        laureatDto.setEmail(laureat.getUser().getEmail());
        laureatDto.setTelephone(laureat.getUser().getTelephone());
        laureatDto.setRole(laureat.getUser().getRole().getName().toString());


        return laureatDto;

    }
    public List<LaureatDto> mapList(List<Laureat> laureats){

        List<LaureatDto> laureatsDtoList = laureats.stream()
                .map(laureat -> map(laureat))
                .collect(Collectors.toList());
        return laureatsDtoList;
    }
}
