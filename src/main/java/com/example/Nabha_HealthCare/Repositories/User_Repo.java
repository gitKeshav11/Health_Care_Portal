package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface User_Repo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    boolean getByEmail(String email);
}