package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.Entity.Appointment;
import com.example.Nabha_HealthCare.Repositories.Appointment_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Appointment_Service {
@Autowired
    private  Appointment_Repo appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatient_PatientId(patientId);
    }

    public List<Appointment> getAppointmentsByPatientName(String name) {
        return appointmentRepository.findByPatient_Name(name);
    }

    public Appointment updateAppointment(Long id, Appointment appointmentDetails) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        existing.setDoctor(appointmentDetails.getDoctor());
        existing.setPatient(appointmentDetails.getPatient());
        existing.setHospital(appointmentDetails.getHospital());
        existing.setAppointmentDate(appointmentDetails.getAppointmentDate());
        existing.setAppointmentTime(appointmentDetails.getAppointmentTime());
        existing.setAppointmentSlot(appointmentDetails.getAppointmentSlot());
        existing.setFees(appointmentDetails.getFees());
        existing.setStatus(appointmentDetails.getStatus());

        return appointmentRepository.save(existing);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
