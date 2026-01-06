package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.Entity.Prescription;
import com.example.Nabha_HealthCare.Service.Prescription_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
@RequiredArgsConstructor
@CrossOrigin("*")
public class Prescription_Controller {
    @Autowired
    private Prescription_Service service;

    @PostMapping("/create")
    public ResponseEntity<Prescription> create(@RequestBody Prescription prescription) {
        return ResponseEntity.ok(service.createPrescription(prescription));
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Prescription> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPrescriptionById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Prescription>> getAll() {
        return ResponseEntity.ok(service.getAllPrescriptions());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Prescription> update(
            @PathVariable Long id,
            @RequestBody Prescription prescription
    ) {
        return ResponseEntity.ok(service.updatePrescription(id, prescription));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deletePrescription(id);
        return ResponseEntity.ok("Prescription deleted successfully");
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Prescription>> byPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(service.getPrescriptionsByPatient(patientId));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Prescription>> byDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(service.getPrescriptionsByDoctor(doctorId));
    }

    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<List<Prescription>> byAppointment(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(service.getPrescriptionsByAppointment(appointmentId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Prescription>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(service.searchPrescriptions(keyword));
    }
}
