package com.breukhschool.backend.controller;

import com.breukhschool.backend.model.*;
import com.breukhschool.backend.repository.*;
import com.breukhschool.backend.requests.NotePathVariableRequest;
import com.breukhschool.backend.requests.NoteBodyRequest;
import com.breukhschool.backend.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
public class NoteController {
        private final NoteService noteService;

    @PostMapping("/classes/{idClasse}/disciplines/{idDiscipline}/evaluations/{idEvaluation}")
    public ResponseEntity<String> addNotes(@PathVariable int idClasse,
                                           @PathVariable int idDiscipline,
                                           @PathVariable int idEvaluation,
                                           @RequestBody List<NoteBodyRequest> noteBodyRequests) {
        return this.noteService.addNotes(idClasse, idDiscipline, idEvaluation, noteBodyRequests);
    }
}
