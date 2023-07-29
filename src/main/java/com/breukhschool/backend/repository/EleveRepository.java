package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EleveRepository extends JpaRepository<Eleve, Integer>{

    Eleve getEleveById(Long eleveId);
}
