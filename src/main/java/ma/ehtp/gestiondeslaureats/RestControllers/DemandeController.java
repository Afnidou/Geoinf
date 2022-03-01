package ma.ehtp.gestiondeslaureats.RestControllers;

import lombok.AllArgsConstructor;
import ma.ehtp.gestiondeslaureats.domain.Demande;
import ma.ehtp.gestiondeslaureats.service.DemandeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DemandeController {

    private DemandeService demandeService;

    @PostMapping("/demandes/{id}/valider")
    @ResponseStatus(HttpStatus.OK)
    public Demande valider_demande(@PathVariable long id){
      return demandeService.valider_une_demande(id);
    }
    @PostMapping("/demandes/{id}/rejeter")
    @ResponseStatus(HttpStatus.OK)
    public Demande rejeter_demande(@PathVariable long id, @RequestBody @NotBlank String motif){
        return demandeService.rejeter_une_demande(id,motif);    
    }

}
