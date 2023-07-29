package com.breukhschool.backend.service;

import com.breukhschool.backend.model.Eleve;
import com.breukhschool.backend.repository.EleveRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.slf4j.SLF4JLogger;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class EleveService {
    private final EleveRepository eleveRepository;

    public Eleve ajouterOuLire(Eleve eleve) {
        Eleve existingEleve = this.eleveRepository.findById(eleve.getId()).orElse(null);
        if (existingEleve == null){
            this.eleveRepository.save(eleve);
            return eleve;
        }
        return existingEleve;
    }

    public Eleve saveEleve(Eleve eleve) {
        return this.eleveRepository.save(eleve);
    }



    public String sortirEleve(List<Long> eleveIds) {
        for (Long eleveId : eleveIds) {
            Eleve eleve = this.eleveRepository.getEleveById(eleveId);
            if (eleve != null) {
                eleve.setEtat(false);
                this.eleveRepository.save(eleve);
            }else {
                throw new RuntimeException("Eleve non trouvé");
            }
        }
        return "Eleves abandonne avec succès";
    }
}
