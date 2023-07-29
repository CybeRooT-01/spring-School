package com.breukhschool.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "eleves")
@NoArgsConstructor
@Getter
@Setter
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String lieu_naissance;
    private String sexe;
    private Boolean profil;
    private Boolean Etat;
    private String email;
    private int matricule;
}
