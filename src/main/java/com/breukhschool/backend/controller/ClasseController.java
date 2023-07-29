package com.breukhschool.backend.controller;

import com.breukhschool.backend.model.*;
import com.breukhschool.backend.service.ClasseService;
import com.breukhschool.backend.service.DisciplineServices;

import com.breukhschool.backend.service.EvaluationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping("/classes")
@AllArgsConstructor
public class ClasseController {

    private final ClasseService classeService;
    private final DisciplineServices disciplineServices;
    private final EvaluationService evaluationService;


    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Classe> ListerClasses(){
        return this.classeService.ListerClasses();
    }
    @PostMapping("/ajouter")
    public Classe ajouterClasse(@RequestBody Classe classe){
        return this.classeService.ajouterClasse(classe);
    }
    @GetMapping("/disciplines")
    public List<Discipline> getAllDisciplines(){
        return this.disciplineServices.getAllDisciplines();
    }
    @PostMapping("/disciplines")
    public Discipline ajouterDiscipline(@RequestBody Discipline discipline){
        return this.disciplineServices.ajouterDiscipline(discipline);
    }
    @GetMapping("/evaluation")
    public List<Evaluation> getevaluation(){
        return this.evaluationService.getEvaluations();
    }
    @PostMapping("/evaluation")
    public Evaluation addEvaluation(@RequestBody Evaluation evaluation){
        return this.evaluationService.creerEvaluation(evaluation);
    }
    @GetMapping("{id}/eleve")
    List<Eleve> getElevesByClasseId(@PathVariable Long id){
        return this.classeService.getElevesParClasse(id);
    }

    @GetMapping(value = "{classeId}/disciplines/{disciplineId}/notes")
    List<Notes> getNotesByClasseIdAndDisciplineId(@PathVariable int classeId, @PathVariable int disciplineId){
        return this.classeService.getNotesParClasseEtDiscipline(classeId, disciplineId);
    }

}
