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
@Table(name="hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;
    private String name;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hospital", "patients", "appointments"})
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("hospital")
    private List<Patient> patients;

    @ManyToOne
    @JoinColumn(name="admin_id")
    private User admin;
}