package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.Classe;
import com.breukhschool.backend.model.Eleve;
import com.breukhschool.backend.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer>{
    List<Eleve> getEleveByClasseId(int id);

    Inscription findInscriptionByEleveId(int eleveId);
}
