package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.DTO.HospitalResponse;
import com.example.Nabha_HealthCare.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Hospital_Repo extends JpaRepository<Hospital, Long> {

    HospitalResponse findByName(String name);
}
