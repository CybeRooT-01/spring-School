package com.breukhschool.backend.controller;

import com.breukhschool.backend.model.Niveau;
import com.breukhschool.backend.service.NiveauService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveaux")
public class NiveauController {
    public NiveauController(NiveauService niveauService) {
        this.niveauService = niveauService;
    }
    private final NiveauService niveauService;
    @GetMapping
    public List<Niveau> getNiveaux(){
        return this.niveauService.getNivaux();
    }
    @PostMapping
    public Niveau ajouterNiveau(@RequestBody Niveau niveau){
        return this.niveauService.ajouterNiveau(niveau);
    }
}
  