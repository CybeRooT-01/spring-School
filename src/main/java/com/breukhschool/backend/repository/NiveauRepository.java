package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauRepository extends JpaRepository<Niveau, Integer> {
    Niveau findByNom(String nom);
}
