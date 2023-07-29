package com.breukhschool.backend.controller;

import com.breukhschool.backend.model.Events;
import com.breukhschool.backend.service.EventsServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evenements")
@AllArgsConstructor
public class EventsController {
    private final EventsServices eventsServices;
    @GetMapping
    public List<Events> getEvents(){
        return this.eventsServices.ListeEvenements();
    }

    @PostMapping
    public Events ajouterEvenement(@RequestBody Events events){
        return this.eventsServices.ajouterEvenement(events);
    }
}
