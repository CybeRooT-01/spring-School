package com.breukhschool.backend.service;

import com.breukhschool.backend.model.*;
import com.breukhschool.backend.repository.*;
import com.breukhschool.backend.requests.NoteBodyRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {
    private final com.breukhschool.backend.repository.ClasseRepository ClasseRepository;
    private final com.breukhschool.backend.repository.DisciplineRepository DisciplineRepository;
    private final com.breukhschool.backend.repository.EvaluationRepository EvaluationRepository;
    private final com.breukhschool.backend.repository.InscriptionRepository InscriptionRepository;
    private final com.breukhschool.backend.repository.NotesRepository NotesRepository;
    private final SemestreRepository semestreRepository;
    private final PonderationRepository ponderationRepository;
    public ResponseEntity<String> addNotes(int idClasse, int idDiscipline, int idEvaluation, List<NoteBodyRequest> noteBodyRequests) {
        Classe classe = ClasseRepository.findById(idClasse).orElse(null);
        Discipline discipline = DisciplineRepository.findById(idDiscipline).orElse(null);
        Evaluation evaluation = EvaluationRepository.findById(idEvaluation).orElse(null);

        if (evaluation == null || classe == null || discipline == null) {
            return ResponseEntity.badRequest().body("Evaluation, classe ou discipline introuvable.");
        }

        for (NoteBodyRequest noteBodyRequest : noteBodyRequests) {
            Inscription inscription = InscriptionRepository.findInscriptionByEleveId(noteBodyRequest.getEleveId());

            if (inscription == null) {
                return ResponseEntity.badRequest().body("Eleve introuvable pour l'ID " + noteBodyRequest.getEleveId());
            }

            Ponderation ponderation = ponderationRepository.findByClasseAndDisciplineAndEvaluation(classe, discipline, evaluation);
            if (ponderation == null) {
                return ResponseEntity.badRequest().body("Ponderation introuvable pour cette classe, discipline et évaluation.");
            }

            Semestre semestre = semestreRepository.findById(1).orElse(null);
            if (semestre == null) {
                return ResponseEntity.badRequest().body("Semestre introuvable.");
            }

            Notes note = new Notes();
            note.setNote(noteBodyRequest.getNote());
            note.setInscription(inscription);
            note.setPonderation(ponderation);
            note.setSemestre(semestre);

            NotesRepository.save(note);
        }

        return ResponseEntity.ok("Notes ajoutées avec succès.");
    }
}
