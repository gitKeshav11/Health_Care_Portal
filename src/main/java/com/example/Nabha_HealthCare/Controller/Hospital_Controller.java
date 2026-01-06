package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.DTO.HospitalRequest;
import com.example.Nabha_HealthCare.DTO.HospitalResponse;
import com.example.Nabha_HealthCare.Entity.Doctor;
import com.example.Nabha_HealthCare.Entity.Patient;
import com.example.Nabha_HealthCare.Service.Hospital_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
@CrossOrigin("*")
public class Hospital_Controller {

    @Autowired
    private Hospital_Service hospitalService;

    // Create
    @PostMapping("/add")
    public ResponseEntity<HospitalResponse> createHospital(@RequestBody HospitalRequest request) {
        return ResponseEntity.ok(hospitalService.createHospital(request));
    }

    // Get All
    @GetMapping("/all")
    public ResponseEntity<List<HospitalResponse>> getAllHospital() {
        return ResponseEntity.ok(hospitalService.getAllHospital());
    }

    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> getHospitalById(@PathVariable Long id) {
        return ResponseEntity.ok(hospitalService.getHospitalById(id));
    }

    // Get doctors of a hospital
    @GetMapping("/{hospitalId}/doctors")
    public List<Doctor> getDoctors(@PathVariable Long hospitalId) {
        return hospitalService.getDoctorsByHospital(hospitalId);
    }

    // Get patients of a hospital
    @GetMapping("/{hospitalId}/patients")
    public List<Patient> getPatients(@PathVariable Long hospitalId) {
        return hospitalService.getPatientsByHospital(hospitalId);
    }

    // Get by Name
    @GetMapping("/byName")
    public ResponseEntity<HospitalResponse> getHospitalByName(@RequestParam String name) {
        return ResponseEntity.ok(hospitalService.getHospitalByName(name));
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<HospitalResponse> updateHospital(
            @PathVariable Long id,
            @RequestBody HospitalRequest request) {
        return ResponseEntity.ok(hospitalService.updateHospital(id, request));
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospital(id);
        return ResponseEntity.ok("Hospital deleted successfully.");
    }
}
