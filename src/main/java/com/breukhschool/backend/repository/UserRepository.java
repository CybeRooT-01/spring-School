package com.breukhschool.backend.repository;

import com.breukhschool.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {


    Users findByEmail(String email);
}
