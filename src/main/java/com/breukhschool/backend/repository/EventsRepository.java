package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, Integer> {

}
