package com.example.Nabha_HealthCare.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="symptoms")
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long symptomId;
    private String symptomName;
    private String description;


    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;


    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;


    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital;
}