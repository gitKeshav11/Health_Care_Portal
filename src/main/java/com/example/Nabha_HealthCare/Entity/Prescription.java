package com.example.Nabha_HealthCare.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="prescriptions")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;


    @ManyToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;


    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;


    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;


    @ManyToOne
    @JoinColumn(name="medicine_id")
    private Medicine medicine;


    private String dosage;
    private String duration;
    private String instructions;
}