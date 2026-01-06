package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Medicine_Repo extends JpaRepository<Medicine,Integer> {

    Optional<Medicine> findByDisease(String disease);

    Optional<Object> findByNameContainingIgnoreCase(String name);
}
