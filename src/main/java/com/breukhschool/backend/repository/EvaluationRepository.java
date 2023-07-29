package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {
    Evaluation findByLibelle(String libelle);
}
