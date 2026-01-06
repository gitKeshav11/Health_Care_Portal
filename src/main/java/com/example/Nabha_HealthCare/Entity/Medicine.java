package com.example.Nabha_HealthCare.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;
    private String name;
    private String salts;
    private String ingredients;
    private Double price;
    private String disease;
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
    private String category;
    private String manufacturer;

}