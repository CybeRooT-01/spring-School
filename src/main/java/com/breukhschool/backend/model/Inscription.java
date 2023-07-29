package com.breukhschool.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "inscriptions")
@NoArgsConstructor
@Getter
@Setter
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date_inscription = new Date();
    @ManyToOne( cascade = {PERSIST, MERGE})
    Eleve eleve;
    @ManyToOne( cascade = {PERSIST, MERGE})
    Classe classe;
    @ManyToOne( cascade = {PERSIST, MERGE})
    AnneeScolaire anneeScolaire;
}
