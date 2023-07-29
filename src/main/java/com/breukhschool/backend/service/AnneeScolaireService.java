package com.breukhschool.backend.service;

import com.breukhschool.backend.model.AnneeScolaire;
import com.breukhschool.backend.repository.AnneeScolaireRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnneeScolaireService {
    private final AnneeScolaireRepository anneeScolaireRepository;

    public AnneeScolaire ajouterOuLire(AnneeScolaire anneeScolaire) {
        AnneeScolaire existingAnneeScolaire = this.anneeScolaireRepository.findByLibelle(anneeScolaire.getLibelle());
        if (existingAnneeScolaire == null){
            this.anneeScolaireRepository.save(anneeScolaire);
            return anneeScolaire;
        }
        return existingAnneeScolaire;
    }
}
