package com.example.Nabha_HealthCare.Repositories;

import com.example.Nabha_HealthCare.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Prescription_Repo extends JpaRepository<Prescription, Long> {

    List<Prescription> findByPatient_PatientId(Long patientId);

    List<Prescription> findByDoctor_DoctorId(Long doctorId);

    List<Prescription> findByAppointment_AppointmentId(Long appointmentId);

    List<Prescription> findByMedicineNameContainingIgnoreCase(String keyword);
}
