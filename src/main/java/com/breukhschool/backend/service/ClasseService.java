package com.breukhschool.backend.service;

import com.breukhschool.backend.model.*;
import com.breukhschool.backend.repository.ClasseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClasseService {
    private final ClasseRepository classeRepository;
    private final NiveauService niveauService;

    public Classe ajouterClasse(Classe classe) {
        Niveau niveau = this.niveauService.lireOuCreerNiveau(classe.getNiveau());
        classe.setNiveau(niveau);
        return this.classeRepository.save(classe);
    }

    public List<Classe> ListerClasses() {
        return this.classeRepository.findAll();
    }

    public Classe ajouterOuLire(Classe classe) {
        Classe existingClasse = this.classeRepository.findById(classe.getId()).orElse(null);
        if (existingClasse == null) {
            this.classeRepository.save(classe);
            return classe;
        }
        return existingClasse;
    }

    public List<Eleve> getElevesParClasse(Long idClasse) {
        return classeRepository.findElevesByClasseId(idClasse);
    }


    public List<Notes> getNotesParClasseEtDiscipline(int classeId, int disciplineId) {
        return classeRepository.findNotesByClasseIdAndDisciplineId(classeId, disciplineId);
    }
}

