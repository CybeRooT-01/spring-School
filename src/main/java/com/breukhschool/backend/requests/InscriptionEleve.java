package com.breukhschool.backend.requests;

import com.breukhschool.backend.model.Eleve;
import com.breukhschool.backend.model.Inscription;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InscriptionEleve {
    private Eleve eleve;
    private Inscription inscription;
}
