package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes, Integer> {
}
