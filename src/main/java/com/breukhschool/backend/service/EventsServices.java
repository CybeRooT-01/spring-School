package com.breukhschool.backend.service;
import com.breukhschool.backend.model.Events;
import com.breukhschool.backend.model.Users;
import com.breukhschool.backend.repository.EventsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventsServices {
    private final EventsRepository eventsRepository;
    private final UserServices userService;

    public List<Events> ListeEvenements() {
        return this.eventsRepository.findAll();
    }

    public Events ajouterEvenement(Events events) {
        Users users = this.userService.lireOuCreerUtilisateur(events.getUsers());
        events.setUsers(users);
        return this.eventsRepository.save(events);
    }
}
