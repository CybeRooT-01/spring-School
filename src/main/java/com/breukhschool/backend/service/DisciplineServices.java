package com.breukhschool.backend.service;

import com.breukhschool.backend.model.Discipline;
import com.breukhschool.backend.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DisciplineServices {


    public DisciplineServices(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    private final DisciplineRepository disciplineRepository;

    public List<Discipline> getAllDisciplines(){
       return this.disciplineRepository.findAll();
    }

    public Discipline ajouterDiscipline(Discipline discipline) {
        Discipline existingDiscipline = this.disciplineRepository.findBylibelle(discipline.getLibelle());
        if (existingDiscipline == null){
            this.disciplineRepository.save(discipline);
            return discipline;
        }
        return existingDiscipline;
    }
}
