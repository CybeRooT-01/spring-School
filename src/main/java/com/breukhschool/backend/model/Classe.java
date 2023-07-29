package com.breukhschool.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "classes")
@NoArgsConstructor
@Getter
@Setter
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 150)
    private String nom;
    @ManyToOne(optional = false, cascade = {PERSIST, MERGE})
    @JoinColumn(name = "niveau_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Niveau niveau;

}
