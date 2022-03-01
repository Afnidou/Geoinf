package ma.ehtp.gestiondeslaureats.service;
import lombok.AllArgsConstructor;
import ma.ehtp.gestiondeslaureats.domain.Demande;
import ma.ehtp.gestiondeslaureats.repositories.DemandeRepository;
import org.springframework.stereotype.Service;
import javax.validation.constraints.NotBlank;

@Service
@AllArgsConstructor
public class DemandeService {

    private final DemandeRepository demandeRepository;

    public Demande valider_une_demande(long id){
        Demande request = demandeRepository.getById(id);
        request.setStatut("Traitee");
        return  demandeRepository.save(request);
    }
    public Demande rejeter_une_demande(long id, @NotBlank String motif_de_rejet){
        Demande request = demandeRepository.getById(id);
        request.setMotif_de_rejet(motif_de_rejet);
        request.setStatut("Rejetee");
        return demandeRepository.save(request);
    }

}
