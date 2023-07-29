package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.AnneeScolaire;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire, Integer> {
    AnneeScolaire findByLibelle(String libelle);
}
