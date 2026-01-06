package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Appointment_Repo extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatient_Name(String name);
    List<Appointment> findByPatient_PatientId(Long patientId);
}
