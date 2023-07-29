package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.Classe;
import com.breukhschool.backend.model.Eleve;
import com.breukhschool.backend.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe, Integer>{
    @Query("SELECT i.eleve FROM Inscription i WHERE i.classe.id = :idClasse")
    List<Eleve> findElevesByClasseId(Long idClasse);
    @Query("SELECT n.id FROM Notes n WHERE n.inscription.classe.id = :classeId AND n.ponderation.discipline.id = :disciplineId")
    List<Notes> findNotesByClasseIdAndDisciplineId(int classeId, int disciplineId);

}
