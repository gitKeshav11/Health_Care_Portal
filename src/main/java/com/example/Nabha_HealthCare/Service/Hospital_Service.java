package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.DTO.HospitalRequest;
import com.example.Nabha_HealthCare.DTO.HospitalResponse;
import com.example.Nabha_HealthCare.Entity.Doctor;
import com.example.Nabha_HealthCare.Entity.Hospital;
import com.example.Nabha_HealthCare.Entity.Patient;
import com.example.Nabha_HealthCare.Entity.User;
import com.example.Nabha_HealthCare.Repositories.Doctor_Repo;
import com.example.Nabha_HealthCare.Repositories.Hospital_Repo;
import com.example.Nabha_HealthCare.Repositories.Patient_Repo;
import com.example.Nabha_HealthCare.Repositories.User_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Hospital_Service {

    @Autowired
    private Hospital_Repo hospitalRepo;

    @Autowired
    private Doctor_Repo doctorRepository;

    @Autowired
    private Patient_Repo patientRepository;

    @Autowired
    private User_Repo userRepository;

    public List<Doctor> getDoctorsByHospital(Long hospitalId) {
        return doctorRepository.findByHospital_HospitalId(hospitalId);
    }

    public List<Patient> getPatientsByHospital(Long hospitalId) {
        return patientRepository.findByHospital_HospitalId(hospitalId);
    }

    // Create Hospital
    public HospitalResponse createHospital(HospitalRequest request) {

        User admin = userRepository.findById(request.getAdminId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        Hospital hospital = new Hospital();
        hospital.setName(request.getName());
        hospital.setAddress(request.getAddress());
        hospital.setPhoneNumber(request.getPhoneNumber());
        hospital.setAdmin(admin);

        Hospital saved = hospitalRepo.save(hospital);

        return mapToResponse(saved);
    }

    // Get All Hospitals
    public List<HospitalResponse> getAllHospital() {
        return hospitalRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Get hospital by ID
    public HospitalResponse getHospitalById(Long id) {
        Hospital hospital = hospitalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        return mapToResponse(hospital);
    }

    // Update Hospital
    public HospitalResponse updateHospital(Long id, HospitalRequest request) {

        Hospital hospital = hospitalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        hospital.setName(request.getName());
        hospital.setAddress(request.getAddress());
        hospital.setPhoneNumber(request.getPhoneNumber());

        if (request.getAdminId() != null) {
            User admin = userRepository.findById(request.getAdminId())
                    .orElseThrow(() -> new RuntimeException("Admin not found"));

            hospital.setAdmin(admin);
        }

        Hospital updated = hospitalRepo.save(hospital);
        return mapToResponse(updated);
    }

    // Delete Hospital
    public void deleteHospital(Long id) {
        hospitalRepo.deleteById(id);
    }


    // MAPPER
    private HospitalResponse mapToResponse(Hospital h) {
        return new HospitalResponse(
                h.getHospitalId(),
                h.getName(),
                h.getAddress(),
                h.getPhoneNumber(),
                h.getAdmin() != null ? h.getAdmin().getUserId() : null,
                h.getAdmin() != null ? h.getAdmin().getName() : null
        );
    }

    public HospitalResponse getHospitalByName(String name) {
        return hospitalRepo.findByName(name);
    }
}

