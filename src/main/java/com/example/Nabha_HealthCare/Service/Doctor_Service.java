package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.Entity.Doctor;
import com.example.Nabha_HealthCare.Repositories.Doctor_Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Doctor_Service {
@Autowired
    private  Doctor_Repo doctorRepository;

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found: " + id));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {
        Doctor existing = getDoctorById(id);

        existing.setName(doctor.getName());
        existing.setGender(doctor.getGender());
        existing.setQualification(doctor.getQualification());
        existing.setEmail(doctor.getEmail());
        existing.setPassword(doctor.getPassword());
        existing.setSpecialist(doctor.getSpecialist());
        existing.setFees(doctor.getFees());
        existing.setAge(doctor.getAge());
        existing.setHospital(doctor.getHospital());

        return doctorRepository.save(existing);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> getDoctorsByHospital(Long hospitalId) {
        return doctorRepository.findByHospital_HospitalId(hospitalId);
    }

    public List<Doctor> getDoctorsBySpecialist(String specialist) {
        return doctorRepository.findBySpecialist(specialist);
    }

    public List<Doctor> searchDoctorsByName(String name) {
        return doctorRepository.findByNameContainingIgnoreCase(name);
    }

    public Doctor loginDoctor(String email, String password) {
        Doctor doctor = doctorRepository.findByEmail(email);

        if (doctor != null && doctor.getPassword().equals(password)) {
            return doctor;
        }
        throw new RuntimeException("Invalid email or password");
    }
}
