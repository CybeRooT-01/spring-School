package com.breukhschool.backend.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotePathVariableRequest {
    private int classeId;
    private int disciplineId;
    private int evaluationId;
}
