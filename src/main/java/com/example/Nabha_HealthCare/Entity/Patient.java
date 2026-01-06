package com.example.Nabha_HealthCare.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private String gender;
    private String email;
    private String password;
    private String disease;
    private Integer age;


    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonIgnoreProperties({"patients", "doctors", "appointments"})
    private Hospital hospital;

    @OneToMany(mappedBy = "patient")
    @JsonIgnoreProperties({"patient", "hospital", "doctor"})
    private List<Appointment> appointments;
}