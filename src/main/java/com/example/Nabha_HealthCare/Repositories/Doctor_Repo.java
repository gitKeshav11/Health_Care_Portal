package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Doctor_Repo extends JpaRepository<Doctor, Long> {

    List<Doctor> findByHospital_HospitalId(Long hospitalId);

    List<Doctor> findBySpecialist(String specialist);

    Doctor findByEmail(String email);

    List<Doctor> findByNameContainingIgnoreCase(String name);

}
