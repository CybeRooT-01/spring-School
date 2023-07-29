package com.breukhschool.backend.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PonderationRequest {
    private int disciplineId;
    private int anneeScolaireId;
    private int evaluationId;
    private int noteMax;
}
