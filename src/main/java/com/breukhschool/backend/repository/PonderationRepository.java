package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.Classe;
import com.breukhschool.backend.model.Discipline;
import com.breukhschool.backend.model.Evaluation;
import com.breukhschool.backend.model.Ponderation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PonderationRepository extends JpaRepository<Ponderation, Integer>{
    Ponderation findByClasseAndDisciplineAndEvaluation(Classe classe, Discipline discipline, Evaluation evaluation);
}
