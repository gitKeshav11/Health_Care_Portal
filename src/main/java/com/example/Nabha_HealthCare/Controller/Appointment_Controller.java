package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.Entity.Appointment;
import com.example.Nabha_HealthCare.Service.Appointment_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class Appointment_Controller {

    @Autowired
    private Appointment_Service appointmentService;

    // Create Appointment
    @PostMapping("/add")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    // Get appointments by Patient ID
    @GetMapping("/byPatient/{patientId}")
    public List<Appointment> getByPatientId(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatientId(patientId);
    }

    // Get appointments by Patient Name
    @GetMapping("/byPatientName/{name}")
    public List<Appointment> getByPatientName(@PathVariable String name) {
        return appointmentService.getAppointmentsByPatientName(name);
    }

    // Update Appointment
    @PutMapping("/update/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(id, appointment);
    }

    // Delete Appointment
    @DeleteMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "Appointment deleted successfully";
    }

    // Get Appointment By ID
    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    // Get All Appointments
    @GetMapping("/all")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }
}
