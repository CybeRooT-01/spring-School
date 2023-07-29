package com.breukhschool.backend.controller;

import com.breukhschool.backend.model.Eleve;
import com.breukhschool.backend.requests.InscriptionEleve;
import com.breukhschool.backend.repository.EleveRepository;
import com.breukhschool.backend.service.EleveService;
import com.breukhschool.backend.service.InscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eleves")
@AllArgsConstructor
public class ELeveController {

    private final EleveService eleveService;
    private final InscriptionService inscriptionService;
    private final EleveRepository eleveRepository;

    @PostMapping
    public Eleve inscrireEleve(@RequestBody  InscriptionEleve inscriptionEleve) {
        return this.inscriptionService.inscrireEleve(inscriptionEleve.getEleve(), inscriptionEleve.getInscription());
    }
    @PutMapping("/sortie")
    public String sortirEleve(@RequestBody List<Long> eleveIds) {
        return this.eleveService.sortirEleve(eleveIds);
    }



}
