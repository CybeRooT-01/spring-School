package com.breukhschool.backend.service;

import com.breukhschool.backend.model.Niveau;
import com.breukhschool.backend.repository.NiveauRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauService {

    public NiveauService(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }

    private final NiveauRepository niveauRepository;

    public List<Niveau> getNivaux() {
        return this.niveauRepository.findAll();
    }

    public Niveau ajouterNiveau(Niveau niveau) {
        Niveau existingNiveau = this.niveauRepository.findByNom(niveau.getNom());
        if (existingNiveau == null){
            this.niveauRepository.save(niveau);
            return niveau;
        }
        return existingNiveau;
    }

    public Niveau lireOuCreerNiveau(Niveau niveau) {
        Niveau existingNiveau = this.niveauRepository.findByNom(niveau.getNom());
        if (existingNiveau == null){
            this.niveauRepository.save(niveau);
            return niveau;
        }
        return existingNiveau;
    }
}
