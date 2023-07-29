package com.breukhschool.backend.service;

import com.breukhschool.backend.model.Users;
import com.breukhschool.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServices {
    private final UserRepository userRepository;

    public List<Users> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Users getUserById(int id) {
        return this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Users modifierUser(int id, Users users) {
        return this.userRepository.findById(id).map(user -> {
            user.setName(users.getName());
            user.setPrenom(users.getPrenom());
            user.setRole(users.getRole());
            user.setEmail(users.getEmail());
            user.setPassword(users.getPassword());
            return this.userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Users ajouterUser(Users users) {
        return this.userRepository.save(users);
    }

    public void supprimerUser(int id) {
        this.userRepository.deleteById(id);
    }

    public Users lireOuCreerUtilisateur(Users users) {
         Users existingUser = this.userRepository.findById(users.getId()).orElse(null);
        if (existingUser == null){
            this.userRepository.save(users);
            return users;
        }
        return existingUser;
    }
}
