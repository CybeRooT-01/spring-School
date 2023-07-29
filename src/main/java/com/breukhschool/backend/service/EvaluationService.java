package com.breukhschool.backend.service;

import com.breukhschool.backend.model.Classe;
import com.breukhschool.backend.model.Evaluation;
import com.breukhschool.backend.model.Ponderation;
import com.breukhschool.backend.repository.EvaluationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;


    public List<Evaluation> getEvaluations() {
        return this.evaluationRepository.findAll();
    }

    public Evaluation creerEvaluation(Evaluation evaluation) {
        Evaluation evaluationExisting = this.evaluationRepository.findByLibelle(evaluation.getLibelle());
        if (evaluationExisting == null){
            this.evaluationRepository.save(evaluation);
            return evaluation;
        }
        return evaluationExisting;
    }

}
