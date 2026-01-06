package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.Entity.Symptom;
import com.example.Nabha_HealthCare.Service.Symptom_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/symptoms")
@CrossOrigin("*")
@RequiredArgsConstructor
public class Symptom_Controller {
    @Autowired
    private Symptom_Service symptomService;

    // Create
    @PostMapping("add")
    public ResponseEntity<Symptom> createSymptom(@RequestBody Symptom symptom) {
        return ResponseEntity.ok(symptomService.createSymptom(symptom));
    }

    // Get one
    @GetMapping("/byId/{id}")
    public ResponseEntity<Symptom> getSymptom(@PathVariable Long id) {
        return ResponseEntity.ok(symptomService.getSymptomById(id));
    }

    // Get all
    @GetMapping("/all")
    public ResponseEntity<List<Symptom>> getAllSymptoms() {
        return ResponseEntity.ok(symptomService.getAllSymptoms());
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<Symptom> updateSymptom(
            @PathVariable Long id,
            @RequestBody Symptom symptom
    ) {
        return ResponseEntity.ok(symptomService.updateSymptom(id, symptom));
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSymptom(@PathVariable Long id) {
        symptomService.deleteSymptom(id);
        return ResponseEntity.ok("Symptom deleted successfully");
    }

    // Get by Doctor
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Symptom>> getByDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(symptomService.getSymptomsByDoctor(doctorId));
    }

    // Get by Patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Symptom>> getByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(symptomService.getSymptomsByPatient(patientId));
    }

    // Get by Hospital
    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<Symptom>> getByHospital(@PathVariable Long hospitalId) {
        return ResponseEntity.ok(symptomService.getSymptomsByHospital(hospitalId));
    }

    // Search
    @GetMapping("/search")
    public ResponseEntity<List<Symptom>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(symptomService.searchSymptoms(keyword));
    }
}
