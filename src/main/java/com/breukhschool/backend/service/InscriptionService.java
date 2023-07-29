package com.breukhschool.backend.service;

import com.breukhschool.backend.model.AnneeScolaire;
import com.breukhschool.backend.model.Classe;
import com.breukhschool.backend.model.Eleve;
import com.breukhschool.backend.model.Inscription;
import com.breukhschool.backend.repository.EleveRepository;
import com.breukhschool.backend.repository.InscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InscriptionService {
    private final InscriptionRepository inscriptionRepository;
    private final EleveService eleveService;
    private final ClasseService classeService;
    private final AnneeScolaireService anneeScolaireService;
    public Eleve inscrireEleve(Eleve eleve, Inscription inscription) {
        Eleve EleveAajoouter = this.eleveService.ajouterOuLire(eleve);
        inscription.setEleve(EleveAajoouter);
        inscription.setClasse(this.classeService.ajouterOuLire(inscription.getClasse()));
        inscription.setAnneeScolaire(this.anneeScolaireService.ajouterOuLire(inscription.getAnneeScolaire()));
        this.inscriptionRepository.save(inscription);
        return EleveAajoouter;
    }
}
