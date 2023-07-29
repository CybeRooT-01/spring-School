package com.breukhschool.backend.model;

import com.breukhschool.backend.enums.TypeUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String prenom;
    private String email;
    private String password;
    private TypeUser role;
}
