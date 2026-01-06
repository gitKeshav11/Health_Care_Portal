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
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String name;
    private String gender;
    private String qualification;
    private String email;
    private String password;
    private String specialist;
    private Double fees;
    private Integer age;


    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonIgnoreProperties({"doctors", "patients", "appointments"})
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "patient", "hospital"})
    private List<Appointment> appointments;
}