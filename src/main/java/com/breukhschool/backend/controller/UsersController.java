package com.breukhschool.backend.controller;

import com.breukhschool.backend.model.Users;
import com.breukhschool.backend.service.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final UserServices userServices;
    @GetMapping
    public List<Users> getUsers(){
        return this.userServices.getAllUsers();
    }
    @GetMapping("/{id}")
    public Users getUser(@PathVariable int id){
        return this.userServices.getUserById(id);
    }
    @PutMapping("/{id}")
    public Users modifierUser(@PathVariable int id, @RequestBody Users users){
        return this.userServices.modifierUser(id, users);
    }
    @PostMapping
    public Users ajouterUser(@RequestBody Users users){
        return this.userServices.ajouterUser(users);
    }
    @DeleteMapping("/{id}")
    public String supprimerUser(@PathVariable int id){
        this.userServices.supprimerUser(id);
        return "utilisateur supprimé";
    }
}
