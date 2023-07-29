package com.breukhschool.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "Niveaux")
@Getter
@Setter
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 255)
    private  Long id;
    @Column(length = 255)
    private  String nom;
}
