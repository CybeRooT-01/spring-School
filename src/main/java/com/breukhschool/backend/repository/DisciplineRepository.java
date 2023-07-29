package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline,Integer> {
    Discipline findBylibelle(String libelle);
}
