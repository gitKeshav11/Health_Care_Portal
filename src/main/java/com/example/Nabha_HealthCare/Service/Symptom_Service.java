package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.Entity.Symptom;
import com.example.Nabha_HealthCare.Repositories.Symptom_Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Symptom_Service {
    @Autowired
    private Symptom_Repo repository;

    public Symptom createSymptom(Symptom symptom) {
        return repository.save(symptom);
    }

    public Symptom getSymptomById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Symptom not found: " + id));
    }

    public List<Symptom> getAllSymptoms() {
        return repository.findAll();
    }

    public Symptom updateSymptom(Long id, Symptom symptom) {
        Symptom existing = getSymptomById(id);

        existing.setSymptomName(symptom.getSymptomName());
        existing.setDescription(symptom.getDescription());
        existing.setDoctor(symptom.getDoctor());
        existing.setPatient(symptom.getPatient());
        existing.setHospital(symptom.getHospital());

        return repository.save(existing);
    }

    public void deleteSymptom(Long id) {
        repository.deleteById(id);
    }

    public List<Symptom> getSymptomsByDoctor(Long doctorId) {
        return repository.findByDoctor_DoctorId(doctorId);
    }

    public List<Symptom> getSymptomsByPatient(Long patientId) {
        return repository.findByPatient_PatientId(patientId);
    }

    public List<Symptom> getSymptomsByHospital(Long hospitalId) {
        return repository.findByHospital_HospitalId(hospitalId);
    }

    public List<Symptom> searchSymptoms(String keyword) {
        return repository.findBySymptomNameContainingIgnoreCase(keyword);
    }
}
