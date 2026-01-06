package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.Entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Symptom_Repo extends JpaRepository<Symptom, Long> {

    List<Symptom> findByDoctor_DoctorId(Long doctorId);

    List<Symptom> findByPatient_PatientId(Long patientId);

    List<Symptom> findByHospital_HospitalId(Long hospitalId);

    List<Symptom> findBySymptomNameContainingIgnoreCase(String name);
}
