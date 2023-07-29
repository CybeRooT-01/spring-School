package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.Classe;
import com.breukhschool.backend.model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre, Integer> {
    Semestre findByClasseAndId(Classe classe, int idSemestre);
}
