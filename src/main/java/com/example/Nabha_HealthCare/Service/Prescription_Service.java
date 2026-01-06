package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.Entity.Prescription;
import com.example.Nabha_HealthCare.Repositories.Prescription_Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Prescription_Service {

    @Autowired
    private  Prescription_Repo repo;

    public Prescription createPrescription(Prescription prescription) {
        return repo.save(prescription);
    }

    public Prescription getPrescriptionById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found: " + id));
    }

    public List<Prescription> getAllPrescriptions() {
        return repo.findAll();
    }

    public Prescription updatePrescription(Long id, Prescription prescription) {
        Prescription existing = getPrescriptionById(id);

        existing.setMedicine(prescription.getMedicine());
        existing.setInstructions(prescription.getInstructions());
        existing.setDosage(prescription.getDosage());
        existing.setDuration(prescription.getDuration());
        existing.setDoctor(prescription.getDoctor());
        existing.setPatient(prescription.getPatient());
        existing.setAppointment(prescription.getAppointment());

        return repo.save(existing);
    }

    public void deletePrescription(Long id) {
        repo.deleteById(id);
    }

    public List<Prescription> getPrescriptionsByPatient(Long patientId) {
        return repo.findByPatient_PatientId(patientId);
    }

    public List<Prescription> getPrescriptionsByDoctor(Long doctorId) {
        return repo.findByDoctor_DoctorId(doctorId);
    }

    public List<Prescription> getPrescriptionsByAppointment(Long appointmentId) {
        return repo.findByAppointment_AppointmentId(appointmentId);
    }

    public List<Prescription> searchPrescriptions(String keyword) {
        return repo.findByMedicineNameContainingIgnoreCase(keyword);
    }
}
