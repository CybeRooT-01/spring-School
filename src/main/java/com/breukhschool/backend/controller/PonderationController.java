package com.breukhschool.backend.controller;

import com.breukhschool.backend.model.*;
import com.breukhschool.backend.repository.*;
import com.breukhschool.backend.requests.PonderationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PonderationController {
    private final PonderationRepository ponderationRepository;
    private final ClasseRepository classeRepository;
    private final DisciplineRepository disciplineRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final EvaluationRepository evaluationRepository;
    @PostMapping("/classes/{idClass}/coef")
    public ResponseEntity<String> addPonderation(@PathVariable int idClass, @RequestBody PonderationRequest request) {

        Classe classe = classeRepository.findById(idClass).orElse(null);
        Discipline discipline = disciplineRepository.findById(request.getDisciplineId()).orElse(null);
        AnneeScolaire anneeScolaire = anneeScolaireRepository.findById(request.getAnneeScolaireId()).orElse(null);
        Evaluation evaluation = evaluationRepository.findById(request.getEvaluationId()).orElse(null);

        if (classe == null || discipline == null || anneeScolaire == null) {
            return ResponseEntity.badRequest().body("Classe, discipline ou année scolaire introuvable.");
        }
        if (evaluation == null) {
            return ResponseEntity.badRequest().body("Evaluation introuvable.");
        }

        Ponderation ponderation = new Ponderation();
        ponderation.setClasse(classe);
        ponderation.setEvaluation(evaluation);
        ponderation.setDiscipline(discipline);
        ponderation.setAnneeScolaire(anneeScolaire);
        ponderation.setNoteMax(request.getNoteMax());

        ponderationRepository.save(ponderation);

        return ResponseEntity.ok("Ponderation ajoutée avec succès.");
    }

}





