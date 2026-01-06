package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.Entity.Patient;
import com.example.Nabha_HealthCare.Service.Patient_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin("*")
@RequiredArgsConstructor
public class Patient_Controller {
@Autowired
    private Patient_Service patientService;

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient p) {
        Patient saved = patientService.addPatient(p);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient p = patientService.getPatientById(id);
        return ResponseEntity.ok(p);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatient() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient p) {
        Patient updated = patientService.updatePatient(id, p);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/discharge{id}")
    public ResponseEntity<String> dischargePatient(@PathVariable Long id) {
        patientService.dischargePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }

    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<Patient>> getPatientsByHospital(@PathVariable Long hospitalId) {
        List<Patient> list = patientService.getPatientsByHospital(hospitalId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Patient>> getPatientByName(@RequestParam String name) {
        List<Patient> list = patientService.getPatientByName(name);
        return ResponseEntity.ok(list);
    }
}
